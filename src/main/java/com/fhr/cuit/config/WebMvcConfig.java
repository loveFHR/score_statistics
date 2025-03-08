package com.fhr.cuit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author FHR
 * @create 2025/03/08 11:28
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 设置允许跨域
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //路由
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                //是否允许证书(cookies)
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //设置允许的时间
                .maxAge(3600);
    }

    /**
     * 添加静态资源映射
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
