package com.basicannon.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.basicannon.config.RootConfig;
import com.basicannon.config.WebConfig;

public class BasicDispatcherInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
     AnnotationConfigWebApplicationContext rootContext=null;
     AnnotationConfigWebApplicationContext webContext=null;
     
     rootContext=new AnnotationConfigWebApplicationContext();
     rootContext.register(RootConfig.class);
     
     webContext=new AnnotationConfigWebApplicationContext();
     webContext.register(WebConfig.class);
     DispatcherServlet dispatcher=null;
     dispatcher=new DispatcherServlet(webContext);
     ServletRegistration.Dynamic sconfig=null;
     sconfig=servletContext.addServlet("dispatcher", dispatcher);
     sconfig.addMapping("*.htm");
     sconfig.setLoadOnStartup(2);
     
	}
	

}
