package com.basicannon.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig {
	@Bean("/basic-annon.htm")
	public Controller viewController()
	{
		ParameterizableViewController pvc=null;
		pvc=new ParameterizableViewController();
		pvc.setViewName("basic-annon");
		return pvc;
		
	}
	
	/*
	 * @Bean
	 * 
	 * public HandlerMapping simpleHandlerMapping() { SimpleUrlHandlerMapping
	 * suhm=null; suhm=new SimpleUrlHandlerMapping(); Properties props=null;
	 * props=new Properties(); props.se
	 * 
	 * }
	 */
	@Bean
	public ViewResolver irViewResolver()
	{
		InternalResourceViewResolver irvr=new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/jsp/");
		irvr.setSuffix(".jsp");
		return irvr;
	}

}
