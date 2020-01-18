package net.jhc.app_info_mng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableCaching
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("net.jhc.app_info_mng.dao")
public class AppInfoMngApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppInfoMngApplication.class, args);
    }

}
