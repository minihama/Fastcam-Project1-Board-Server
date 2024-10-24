package com.boardserver.boardserver.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.boardserver.boardserver.utils.SessionUtil;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Component
@Aspect
@Log4j2
public class LoginCheckAspect {
    @Around("@annotation(com.boardserver.boardserver.aop.LoginCheck) && @ annotation(loginCheck)")
    public Object adminLoginCheck(ProceedingJoinPoint proceedingJoinPoint, LoginCheck loginCheck) throws Throwable{
        HttpSession session = (HttpSession)((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        String id = null;
        int idIndex = 0;

        String userType = loginCheck.type().toString();
        switch (userType) {
            case "ADMIN": {
                id = SessionUtil.getLoginAdminId(session);
                break;
            }
            case "USER": {
                id = SessionUtil.getLoginMemberId(session);
                break;
            }
        }
        if (id == null) {
            log.error(proceedingJoinPoint.toString()+"accuntName : "+id);
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "로그인한 ID 값을 확인해 주세요.") {};
        }

        Object[] modefiedArgs = proceedingJoinPoint.getArgs();

        if(proceedingJoinPoint != null)
        modefiedArgs[idIndex] = id;

        return proceedingJoinPoint.proceed(modefiedArgs);
    }
}
