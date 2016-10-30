package de.fh_kiel.person.checkmethod;

/**
 * Created by amit on 30.10.16.
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class CheckAspect {


    @Around("execution(* de.fh_kiel.person.model.CompanyService.getAllCompaniesSize())")
    public Object companyAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking object method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking invoking method. Return value="+value);
        return value;
    }
}