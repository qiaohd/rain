package com.rao.config.auth;

import com.rao.util.ScanIgnorePathUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import java.util.List;

/**
 * 资源服务器配置
 *
 * @author raojing
 * @date 2019/12/3 21:37
 */
@Slf4j
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 获取所有加了 IgnoreTokenAuth 注解的url
        List<String> allIgnoreTokenAuthUrl = ScanIgnorePathUtil.getAllIgnoreTokenAuthUrl("com.rao.controller");
        allIgnoreTokenAuthUrl.add("/swagger-ui.html");
        allIgnoreTokenAuthUrl.add("/swagger-resources/**");
        allIgnoreTokenAuthUrl.add("/webjars/**");
        allIgnoreTokenAuthUrl.add("/v2/**");
        log.info("allIgnoreTokenAuthUrl: {}", allIgnoreTokenAuthUrl);
        http.authorizeRequests()
                .antMatchers(allIgnoreTokenAuthUrl.toArray(new String[]{})).permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 配置资源 ID
        resources.resourceId("backend-resources").stateless(true);
        resources.authenticationEntryPoint(new AuthExceptionEntryPoint());
    }

}
