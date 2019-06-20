package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
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

	@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage()
	{
	}

	// create a pointcut for getter methods
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	private void getter()
	{
	}

	// create a pointcut for setter methods
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	private void setter()
	{
	}

	// create a pointcut: include package ... exclude getter/setter
	@Pointcut(("forDaoPackage() && !(getter() || setter())"))
	private void forDaoPackageNoGetterSetter()
	{
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n====>>> Executing @Before advice on method");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics()
	{
		System.out.println("\n====>>> Performing API analytics");
	}

}
