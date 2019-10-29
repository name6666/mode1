package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("net.jhc.app_info_mng.dao")
@SpringBootApplication
public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 * @param devCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode)throws Exception;
}
