package net.jhc.app_info_mng.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidCfg {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource DruidCfg() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> intmap = new HashMap<>();
        intmap.put("loginUsername", "root");
        intmap.put("loginPassword", "123456");
        bean.setInitParameters(intmap);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
//        Map<String, String> intmap = new HashMap<>();
//        intmap.put("exclusions", "*.js,*.css,/druid/*");
//        bean.setInitParameters(intmap);
        return bean;
    }
}
