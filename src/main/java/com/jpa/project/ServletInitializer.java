package com.jpa.project;

import com.jpa.project.config.sitemesh.SiteMeshFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletInitializer extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JpaApplication.class);
	}

	@Bean
	public FilterRegistrationBean siteMeshFilter(){
		FilterRegistrationBean filter = new FilterRegistrationBean();
		SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
		filter.setFilter(siteMeshFilter);
		return filter;
	}
}
