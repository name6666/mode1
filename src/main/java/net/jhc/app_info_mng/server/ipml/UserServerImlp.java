package net.jhc.app_info_mng.server.ipml;

import net.jhc.app_info_mng.dao.UserMapper;
import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.Userss;
import net.jhc.app_info_mng.server.UserServer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServerImlp implements UserServer {
    @Resource
    private UserMapper zyuserMapper;

    @Override
    @Transactional
    public boolean addUser(Md md) throws Exception {
        boolean fg = false;
        if (zyuserMapper.UserAdd(md) > 0) {
            fg = true;
        }
        return fg;
    }


    @Override
    public boolean updateUser(Md md) throws Exception {
        boolean fg = false;
        if (zyuserMapper.UserUpdate(md) > 0) {
            fg = true;
        }
        return fg;
    }
    @Cacheable(cacheNames = {"findUserbyId"})
    @Override
    public Md findUserbyId(Integer uid) throws Exception {
        System.out.println("!!!!!!!!!!!!");
        return zyuserMapper.findUserbyId(uid);
    }

    @Override
    public boolean deluser(int id) throws Exception {
        boolean fg = false;
        if (zyuserMapper.deluser(id) > 0) {
            fg = true;
        }
        return fg;
    }

    @Cacheable(cacheNames = {"findUserList"})
    @Override
    public List<Md> findUserList(String uName) throws Exception {
        System.out.println("?????????");
        return zyuserMapper.findUserName(uName);
    }

    @Override
    public Md findUserPwdbyUname(String uName, String uPassWord) throws Exception {
        List<Md> list = zyuserMapper.findUserName(uName);
        if (list != null) {
            Md m = list.get(0);
            if (m != null) {
                if (m.getUPassWord().equals(uPassWord)) {
                    return m;
                }
                return null;
            }
        } else {
            return null;
        }
        return null;
    }
}
