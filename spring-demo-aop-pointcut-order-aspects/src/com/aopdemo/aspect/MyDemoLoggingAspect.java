package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n====>>> Executing @Before advice on method");
	}

	
	
	

}
