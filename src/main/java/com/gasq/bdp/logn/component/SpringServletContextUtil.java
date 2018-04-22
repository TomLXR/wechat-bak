package com.gasq.bdp.logn.component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class SpringServletContextUtil implements ServletContextListener{
private static ServletContext  sc;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sc=sce.getServletContext();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		sc=null;
		
	}
	
	public static ServletContext getCx(){
		return sc;
	}

	
	
}
