package com.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect
{
	// this is where we add all of our related advices for logging

	// let's start with @Before advice

	// @Before("execution(public void updateAccount())")
	// @Before("execution(void updateAccount())")
	// @Before("execution(* updateAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(public void com.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(void add*())")
	// @Before("execution(void add*())")
	// @Before("execution(* add*(com.aopdemo.Account))")
	// @Before("execution(* add*(..))")
	// @Before("execution(* add*(com.aopdemo.Account, ..))")
	// structure (return type) (package) (class) (method) (params)

	// add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result)
	{
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

		// print out the results of the method call
		System.out.println("\n=====>>>Result is: " + result);

		// let's post-process the data ... let's modify it

		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		// print out the results of the method call
		System.out.println("\n=====>>>Result is: " + result);

	}

	private void convertAccountNamesToUpperCase(List<Account> result)
	{
		// loop trough accounts
		for (Account tempAccount : result)
		{

			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();

			// update the name on the account
			tempAccount.setName(theUpperName);
		}

	}

	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
	{
		System.out.println("\n====>>> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: " + methodSignature);

		// display method arguments

		// get args
		Object[] args = theJoinPoint.getArgs();

		// loop thru args
		for (Object tempArg : args)
		{
			System.out.println(tempArg);

			if (tempArg instanceof Account)
			{
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;

				System.out.println("account name: " + theAccount.getName());
				System.out.println("account level: " + theAccount.getLevel());
			}
		}
	}

}
