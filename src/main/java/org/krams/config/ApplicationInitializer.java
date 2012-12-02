package org.krams.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//Load application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(ApplicationContext.class);
		rootContext.setDisplayName("Spring Thymeleaf Tutorial");
		
		//Context loader listener 
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		//Dispatcher servlet
		ServletRegistration.Dynamic dispatcher = 
				servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1); 
		dispatcher.addMapping("/");
	}

}
