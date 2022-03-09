package com.work.aop;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;
//日志切面类
@Aspect
@Slf4j
@Component
public class LogAspects {
	@Pointcut("execution(public * com.work.*.*.*(..))")
	public void pointCut(){};
	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint){log.info(joinPoint.getSignature().getName()+"运行前....参数列表是:{"+Arrays.asList(joinPoint.getArgs())+"}"); }
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint){
		log.info(joinPoint.getSignature().getName()+"运行结束......");
	}
	@AfterReturning(value="pointCut()",returning="result")
	public void logReturn(Object result){
		log.info("正常返回......运行结果是:{"+result+"}");
	}
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void logException(Exception exception){
		log.info("运行异常......异常信息是:{"+exception+"}");
	}
}
