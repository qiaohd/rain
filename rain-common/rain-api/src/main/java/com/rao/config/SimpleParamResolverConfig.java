package com.rao.config;

import com.rao.component.resolver.SimpleParamResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义的接口参数解析器
 *
 * @author raojing
 */
@Configuration
public class SimpleParamResolverConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new SimpleParamResolver());
    }

}
