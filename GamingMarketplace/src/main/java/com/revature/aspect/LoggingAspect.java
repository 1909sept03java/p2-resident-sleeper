package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // marks class as containing advice, prevents autoproxying (from AspectJ!)
@Component // stereotype indicating that LoggingAspect is a Spring bean
public class LoggingAspect {
	
	
	// could create Logger as a bean and inject it
	private static Logger log = Logger.getRootLogger();

	// INFO log when a method is executed with no incident
	// ERROR log when exception is thrown
	// WARN log when "chase" is called (proof-of-concept for pattern matching)

	// after any method in service package executes normally
	@AfterReturning(pointcut = "within(com.revature.service.*)")
	public void logAfterReturn(JoinPoint jp) {
		System.out.println("in logAfterReturn");
		log.info(jp.getSignature());
	}
	
	@AfterReturning(pointcut = "within(com.revature.controller.*)")
	public void logAfterControllerReturn(JoinPoint jp) {
		System.out.println("in logAfterControllerReturn");
		log.info(jp.getSignature());
	}

	// after any method in any package throws any Throwable
	@AfterThrowing(pointcut = "within(*)", throwing = "t")
	public void logAfterThrow(JoinPoint jp, Throwable t) {
		log.error(jp.getSignature() + " threw " + t.getClass() + " with stack trace: " + t.getStackTrace());
	}

}
