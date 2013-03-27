package cn.web.domain;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ConcurrentOperationExecutor implements Ordered {
   
   private static final int DEFAULT_MAX_RETRIES = 2;

   private int maxRetries = DEFAULT_MAX_RETRIES;
   private int order = 1;

   public void setMaxRetries(int maxRetries) {
      this.maxRetries = maxRetries;
   }
   
   public int getOrder() {
      return this.order;
   }
   
   public void setOrder(int order) {
      this.order = order;
   }
   

   @Around("execution(* org.liukai.tutorial.controller.*.*(..))")
   public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable { 
      int numAttempts = 0;
     Exception r;
      do {
    	  System.out.println(pjp.getSignature());
         numAttempts++;
         try { 
            return pjp.proceed();
         }
         catch(Exception ex) {
            r = new Exception("adfasdf");
         }
      }
      while(numAttempts <= this.maxRetries);
      throw r;
   }

}
