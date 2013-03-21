package com.web.log;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet { 
	 
	 public void init() {
		  String prefix =  getServletContext().getRealPath("/");
		  String file = getInitParameter("log4j");//配置文件位置
		  if(file != null) {  
			  PropertyConfigurator.configure(prefix+file); 
		} 
	 }

}