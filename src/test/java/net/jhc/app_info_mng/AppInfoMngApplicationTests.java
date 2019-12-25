package net.jhc.app_info_mng;

import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.Userss;
import net.jhc.app_info_mng.server.UserServer;
import net.jhc.app_info_mng.server.ipml.UserServersImlp;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AppInfoMngApplicationTests {

    @Autowired
    private UserServersImlp imlp;


    @Test
    void contextLoads() throws Exception {
        Userss u= imlp.findUserPwdbyUname("张三","s217701");
        System.out.println(u.toString());

    }

}
