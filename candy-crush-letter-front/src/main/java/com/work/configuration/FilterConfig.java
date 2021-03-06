package com.work.configuration;

import com.work.filter.CSRFFilter;
import com.work.filter.XSSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class FilterConfig {
    /**
     *  csrf过滤拦截器
     */
    @Bean
    public FilterRegistrationBean csrfFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CSRFFilter());
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<>();
//        initParameters.put("referer", "http://localhost:9999");
        /* initParameters.put("isIncludeRichText", "true"); */
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
    /**
     * xss过滤拦截器
     */
    @Bean
    public FilterRegistrationBean xssFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XSSFilter());
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        Map<String, String> initParameters = new HashMap<>();
        filterRegistrationBean.setInitParameters(initParameters);
        return filterRegistrationBean;
    }
}
