package net.jhc.app_info_mng.server.ipml;

import net.jhc.app_info_mng.dao.UserMapper;
import net.jhc.app_info_mng.pojo.User;
import net.jhc.app_info_mng.server.UserServer;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServerImlp implements UserServer {
    @Resource
    private UserMapper zyuserMapper;

    @Transactional
    @Override
    public boolean addUser(User md) throws Exception {
        boolean fg = false;
        if (zyuserMapper.insertSelective(md) > 0) {
            fg = true;
        }
        return fg;
    }


    @Override
    public boolean updateUser(User md) throws Exception {
        boolean fg = false;
        if (zyuserMapper.updateByPrimaryKeySelective(md) > 0) {
            fg = true;
        }
        return fg;
    }
    @CachePut(cacheNames = {"findUserbyId"})
    @Override
    public User findUserbyId(Integer uid) throws Exception {
        return zyuserMapper.selectByPrimaryKey(uid);
    }

    @Override
    public boolean deluser(int id) throws Exception {
        boolean fg = false;
        if (zyuserMapper.deleteByPrimaryKey(id) > 0) {
            fg = true;
        }
        return fg;
    }

    @CachePut(cacheNames = {"findUserList"})
    @Override
    public List<User> findUserList(String uName) throws Exception {
        return zyuserMapper.findUserName(uName);
    }

    @Override
    public User findUserPwdbyUname(String uName, String uPassWord) throws Exception {
        List<User> list = zyuserMapper.findUserName(uName);
        if (list != null) {
            User m = list.get(0);
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
