package spring.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class HandlerAspect {
    private final static Logger LOG = LogManager.getLogger(HandlerAspect.class);

    @Pointcut("execution(* spring.hander.IHandler.process(..))")
    public void allHandlersProcess() {
    }

    @Pointcut("execution(* spring..*.*(..))")
    public void logProcess() {
    }


    @Before("logProcess()")
    public void beforeMethod(JoinPoint point) {
        LOG.debug("Before " + point.toString());
    }

    @After("logProcess()")
    public void afterMethod(JoinPoint jp) {
        LOG.debug("After " + jp.toString());
    }

    @AfterThrowing(value = "allHandlersProcess()", throwing = "ex")
    public void afterThrow(Throwable ex) {
        LOG.error("Exception - ", ex.getMessage(), ex);
    }

    @Around("allHandlersProcess()")
    public Object processTime(ProceedingJoinPoint jp) throws Throwable {
        final long start = System.currentTimeMillis();
        Object result = jp.proceed();
        final long end = System.currentTimeMillis();
        final long timeMethod = end - start;
        LOG.debug("Time process method " + timeMethod);
        System.out.println("Time process method " + timeMethod);
        return result;
    }
}

