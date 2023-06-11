package cn.edu.cqut.crmservice.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    //设置要拦截的URL
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**")  //拦截所有请求
                .excludePathPatterns("/sysUser/login");  //不拦截的URL
    }

    @Bean   //把我们写的拦截器注入到容器
    public AuthInterceptor authenticationInterceptor() {
        return new AuthInterceptor();
    }
}

