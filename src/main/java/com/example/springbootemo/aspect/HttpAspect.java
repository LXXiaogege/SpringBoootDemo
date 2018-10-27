package com.example.springbootemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class HttpAspect {

private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.springbootemo.controller.GirlController.*(..))")
    public void log(){
        //不会被执行
        logger.info("aspect");
}
    @Before("log()")
    public void before(JoinPoint joinpoint){
        //打印出网页信息
    ServletRequestAttributes attribute=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest request=attribute.getRequest();
    logger.info("before aspect");

    //url
    logger.info("url={}",request.getRequestURL());

    //method
    logger.info("method={}",request.getMethod());

    //ip
    logger.info("ip={}",request.getRemoteAddr());

    //class method
    logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+ "." + joinpoint.getSignature().getName());

    //参数
        logger.info("args={}",joinpoint.getArgs());
    }

@After("log()")
    public void after(){
        logger.info("after aspect");
}
    @AfterReturning(returning = "object", pointcut = "log()")//在after之后进行，限定了返回值，如果抛出异常则不执行
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}

