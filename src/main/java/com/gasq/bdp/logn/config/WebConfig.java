package com.gasq.bdp.logn.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/templates/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/templates/");
		registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
		// registry.addResourceHandler("/webapp/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX
		// + "/webapp/");
		super.addResourceHandlers(registry);
	}

	// @Bean
	// public ViewResolver getViewResolver(){
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setPrefix("/WEB-INF/jsp/");
	// resolver.setSuffix(".jsp");
	// resolver.setViewClass(JstlView.class);
	// return resolver;
	// }

	@Bean
	public HandlerAdapter mappingJackson2HttpMessageConverter() {
		//创建RequestMappingHandlerAdapter适配器  
        RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();  
        // HTTP JSON转换器  
        MappingJackson2HttpMessageConverter  jsonConverter = new MappingJackson2HttpMessageConverter();  
        //MappingJackson2HttpMessageConverter接收JSON类型消息的转换  
        MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;  
        List<MediaType> mediaTypes = new ArrayList<MediaType>();  
        mediaTypes.add(mediaType);  
        //加入转换器的支持类型  
        jsonConverter.setSupportedMediaTypes(mediaTypes);  
        //往适配器加入json转换器  
        rmhd.getMessageConverters().add(jsonConverter);  
        return rmhd;  
	}
}
