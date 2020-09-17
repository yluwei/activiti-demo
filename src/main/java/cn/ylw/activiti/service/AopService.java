package cn.ylw.activiti.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * aop
 *
 * @author yanluwei
 * @date 2020/9/17
 */
@Service
@Aspect
public class AopService {

    @Pointcut("execution(* cn.ylw.activiti.controller.AopController.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public String before() {
        System.out.println("前置");
        return "hello";
    }

    //@Around("pointCut()")
    @ResponseBody
    public String around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截");
        Object proceed = joinPoint.proceed();
        System.out.println(proceed);
        System.out.println("放行");
        return "好的";
    }
}
