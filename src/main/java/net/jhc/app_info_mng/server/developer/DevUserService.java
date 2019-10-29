package net.jhc.app_info_mng.server.developer;

import net.jhc.app_info_mng.pojo.DevUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public interface DevUserService {
	/**
	 * 用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser login(String devCode, String devPassword) throws Exception;
}
