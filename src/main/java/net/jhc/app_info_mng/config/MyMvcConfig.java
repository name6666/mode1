package net.jhc.app_info_mng.config;

import net.jhc.app_info_mng.utils.SysInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SysInterceptor()).addPathPatterns("dev/flatfrom/**","/manager/flatfrom/**")
                .excludePathPatterns("/dev/login","/","/manager/login").excludePathPatterns("/static/**");
    }
}
