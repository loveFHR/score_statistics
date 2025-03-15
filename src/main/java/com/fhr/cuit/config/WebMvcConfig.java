package com.fhr.cuit.config;

import com.fhr.cuit.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author FHR
 * @create 2025/03/08 11:28
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final TokenInterceptor tokenInterceptor;

    public WebMvcConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/user/login","/favicon.ico");
    }

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
