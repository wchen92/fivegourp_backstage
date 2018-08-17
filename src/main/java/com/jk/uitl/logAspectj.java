/** 
 * <pre>项目名称:maven-controller 
 * 文件名称:LogAspectj.java 
 * 包名:com.jk.aspectj 
 * 创建日期:2018年5月11日下午7:31:40 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.uitl;

import com.alibaba.fastjson.JSON;
import com.jk.model.Log;
import com.jk.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * <pre>项目名称：maven-controller    
 * 类名称：LogAspectj    
 * 类描述：    
 * 创建人：王晨 
 * 创建时间：2018年5月11日 下午7:31:40    
 * 修改人：王晨
 * 修改时间：2018年5月11日 下午7:31:40    
 * 修改备注：       
 * @version </pre>    
 */
@Aspect
@Component
public class logAspectj {
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	HttpServletRequest request;

	@Pointcut("execution(* com.jk.service..*.*(..))")
	public void logPointcut(){}

    public ExecutorService fixedThreadPool = Executors.newSingleThreadExecutor();
    @AfterReturning(value="logPointcut()",returning="rtv")
    public void saveLog(JoinPoint JoinPoint, Object rtv){
    	String className = JoinPoint.getTarget().getClass().getSimpleName();
    	String methodName = JoinPoint.getSignature().getName();
    	Log  logBean = new Log();
    	logBean.setClassname(className);
    	logBean.setMethodName(methodName);
    	logBean.setCreateTime(new Date());
		 User loginUser = (User) request.getSession().getAttribute("loginUser");
		 if(loginUser!=null){
			 logBean.setUserid(loginUser.getText());
		 }else{
			 logBean.setUserid("未登录");
		 }

    	System.out.println(className);
    	System.out.println(methodName);
		String log = JSON.toJSONString(logBean);
		fixedThreadPool.execute(new CreateAop(amqpTemplate,log));

    }
}
