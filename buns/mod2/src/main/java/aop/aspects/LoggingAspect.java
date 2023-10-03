package aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    @Before("aop.aspects.Pointcuts.allAddMethods() || aop.aspects.Pointcuts.allGetMethods() || aop.aspects.Pointcuts.allReturnMethods()")
    public void beforeAddMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Calling method " + methodName + " with arguments: " + Arrays.toString(args));
    }

    @Around("aop.aspects.Pointcuts.allAddMethods() || aop.aspects.Pointcuts.allGetMethods() || aop.aspects.Pointcuts.allReturnMethods()")
    public Object aroundAddMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("Calling method " + methodName + " with arguments: " + Arrays.toString(args));
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
            System.out.println("Method " + methodName + " successfully executed with result: " + result);
        } catch (Exception e) {
            System.out.println("Method " + methodName + " threw an exception: " + e.getMessage());
            throw e;
        }
        return result;
    }
}
