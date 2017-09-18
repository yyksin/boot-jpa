package com.jpa.project.config;

import com.jpa.project.sitemesh.SiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by IMC021 on 2017. 9. 11..
 */
public class SiteMeshConfig extends WebMvcConfigurerAdapter{

    public FilterRegistrationBean siteMeshFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        SiteMeshFilter siteMeshFilter = new SiteMeshFilter();
        filter.setFilter(siteMeshFilter);
        return filter;
    }
}
