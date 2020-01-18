package net.jhc.app_info_mng.server.ipml;


import net.jhc.app_info_mng.dao.SuperUserMapper;
import net.jhc.app_info_mng.pojo.SuperUser;
import net.jhc.app_info_mng.server.SuperUserServer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuperUserImpl implements SuperUserServer {
    @Resource
    private SuperUserMapper superUserMapper;
    @Override
    public boolean addUser(SuperUser superUser) throws Exception {
        boolean fg = false;
        if (superUserMapper.insertSelective(superUser) > 0) {
            fg = true;
        }
        return false;
    }

    @Override
    public SuperUser findUserPwdbyUname(String sName, String sPassword) throws Exception {
        SuperUser s=superUserMapper.findSuperUserName(sName);
        if (s !=null) {
            if (s.getSPassword().equals(sPassword)){
                return s;
            }
            return null;
        }
        return null;
    }

//    @Cacheable(cacheNames = {"findSuperUserAllbyUname"})
    @Override
    public List<SuperUser> findSuperUserAllbyUname(String sName) throws Exception {
        return superUserMapper.findSuperUserAllbyUname(sName);
    }
}
