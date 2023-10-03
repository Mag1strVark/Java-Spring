package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    @Pointcut("execution(* add*(..))")
    public void allAddMethods(){}

    @Pointcut("execution(* get*(..))")
    public void allGetMethods(){}

    @Pointcut("execution(* return*(..))")
    public void allReturnMethods(){}
}
