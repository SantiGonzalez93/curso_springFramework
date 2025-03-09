package santi.springboot.curso.aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class GreetingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    // execution (plus Type of return and name of the class) ---> This is to specify the joinPoint

    //@Before("execution(String santi.springboot.curso.aop.service.IGreetingService.sayHello(..))")
    @Before("execution(* santi.springboot.curso.aop.service.IGreetingService.*(..))")
    public void loggerBefore (JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos: " + args);
    }


    @After("execution(* santi.springboot.curso.aop.service.IGreetingService.*(..))")
    public void loggerAfter(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos: " + args);
    }


}
