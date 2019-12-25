package net.jhc.app_info_mng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("net.jhc.app_info_mng.dao")
public class AppInfoMngApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppInfoMngApplication.class, args);
    }

}
