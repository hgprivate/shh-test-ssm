package cn.shh.test.ssm.common.aop;

import cn.shh.test.ssm.common.annotations.SSMLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 基于 aop 实现自定义注解{@link SSMLogger}的功能
 */
@Component
@Aspect
public class LoggerAspect {
    @Pointcut("@annotation(cn.shh.test.ssm.common.annotations.SSMLogger)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("==================前置通知==================");
        // 连接点 方法签名信息
        Signature signature = joinPoint.getSignature();
        // 连接点 方法参数信息
        Object[] args = joinPoint.getArgs();
    }

    @After("pointCut()")
    public void after(){
        System.out.println("==================后置通知==================");
    }

    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("==================返回通知==================");
    }

    @AfterThrowing("pointCut()")
    public void afterThrow(){
        System.out.println("==================异常通知==================");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp){
        System.out.println("==================环绕通知前==================");
        try {
            jp.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("==================环绕通知后==================");
        }
    }
}