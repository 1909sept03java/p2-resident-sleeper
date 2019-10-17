package com.revature.aspect;

/*
 * 
 * @Aspect // marks class as containing advice, prevents autoproxying (from
 * AspectJ!)
 * 
 * @Component // stereotype indicating that LoggingAspect is a Spring bean
 * public class LoggingAspect {
 * 
 * // could create Logger as a bean and inject it private static Logger log =
 * Logger.getRootLogger();
 * 
 * // after any method in service package executes normally
 * 
 * @AfterReturning(pointcut = "within(com.revature.service.*)") public void
 * logAfterReturn(JoinPoint jp) { System.out.println("in services! woot woot!");
 * log.info(jp.getSignature()); }
 * 
 * @AfterReturning(pointcut = "within(com.revature.controller.*)") public void
 * logAfterControllerReturn(JoinPoint jp) {
 * System.out.println("in controller! woot woot!"); log.info(jp.getSignature());
 * }
 * 
 * // after any method in any package throws any Throwable
 * 
 * @AfterThrowing(pointcut = "within(*)", throwing = "t") public void
 * logAfterThrow(JoinPoint jp, Throwable t) { log.error(jp.getSignature() +
 * " threw " + t.getClass() + " with stack trace: " + t.getStackTrace()); }
 * 
 * }
 */
