package net.jhc.app_info_mng.server.developer.ipml;


import net.jhc.app_info_mng.dao.DevUserMapper;
import net.jhc.app_info_mng.pojo.DevUser;
import net.jhc.app_info_mng.server.developer.DevUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@MapperScan("net.jhc.app_info_mng.dao")
@SpringBootApplication
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		// TODO Auto-generated method stub
		DevUser user = null;
		//查找有没有devcode的用户
		user = mapper.getLoginUser(devCode);
		//匹配密码
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

}
