package it.polito.ai;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/chat").setViewName("chat");
        //registry.addViewController("/index").setViewName("index");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/static/images/");
		super.addResourceHandlers(registry);
	}

	/*@Override

	public void configureViewResolvers(ViewResolverRegistry registry) 
	{
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
		resolver.setPrefix("/static/images/");
		resolver.setSuffix(".png");

		super.configureViewResolvers(registry);
	}*/
	
	
	

}
