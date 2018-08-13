/** 
 * <pre>项目名称:maven-model 
 * 文件名称:Log.java 
 * 包名:com.jk.model.user 
 * 创建日期:2018年5月11日下午8:23:03 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/** 
 * <pre>项目名称：maven-model    
 * 类名称：Log    
 * 类描述：    
 * 创建人：董良得 
 * 创建时间：2018年5月11日 下午8:23:03    
 * 修改人：董良得
 * 修改时间：2018年5月11日 下午8:23:03    
 * 修改备注：       
 * @version </pre>    
 */
@Document(collection="log")
public class Log implements Serializable {
   private static final long serialVersionUID = 1L;
   private 	String id;
   private 	String classname;
   private 	String  methodName;
   private 	String userid;
   private 	String ip;
   private Date createTime;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getClassname() {
	return classname;
}
public void setClassname(String classname) {
	this.classname = classname;
}
public String getMethodName() {
	return methodName;
}
public void setMethodName(String methodName) {
	this.methodName = methodName;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
/* (non-Javadoc)    
 * @see java.lang.Object#toString()    
 */
@Override
public String toString() {
	return "Log [id=" + id + ", classname=" + classname + ", methodName=" + methodName + ", userid=" + userid + ", ip="
			+ ip + ", createTime=" + createTime + "]";
}
   
   
}
