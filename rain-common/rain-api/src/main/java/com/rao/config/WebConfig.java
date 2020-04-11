package com.rao.config;

import com.rao.component.filter.RequestProxyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author raojing
 * @date 2020-04-11 11:12
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean requestProxyFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RequestProxyFilter());
        registration.addUrlPatterns("/*");
        registration.setName("RequestProxyFilter");
        registration.setOrder(1);
        return registration;
    }
}
