package com.project.employeemanagement.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.project.employeemanagement.entity.Employee;
import com.project.employeemanagement.exception.EmployeeNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
public class LoggingAspect {

	@Pointcut("exceution(* com.project.employeemanagement.controller.*(. .))")
public void loggingAspect() {}	
	
	@Before("loggingAspect()")
	public void before(JoinPoint jp) {
		log.info("Entering into the Method :"+jp.getSignature());
	}
	
	@After("loggingAspect()")
	public void after(JoinPoint jp) {
		log.info("Exiting from the Method :"+jp.getSignature());
	}
	
	@AfterReturning(value="exceution(* com.project.employeemanagement.*.*(. .))",returning="employee")
	public void afterReturn(JoinPoint jp,Employee employee) {
		log.info("Exiting from the Method :"+jp.getSignature()+" -----  "+employee);
	}
	
	@AfterThrowing(value="exceution(* com.project.employeemanagement.*.*(. .))",throwing="ex")
	public void afterThrow(JoinPoint jp,EmployeeNotFoundException ex) {
		log.info("Exiting from the Method :"+jp.getSignature()+"  ---------   "+ex.getLocalizedMessage());
	}
	
//	@Around("loggingAspect()")
//	public Object around(ProceedingJoinPoint jp) throws Throwable {
//		Object obj = jp.proceed();
//		return obj;
//	}
	
}
