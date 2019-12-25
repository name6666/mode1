package net.jhc.app_info_mng.server.ipml;

import net.jhc.app_info_mng.dao.UserMappers;
import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.Userss;
import net.jhc.app_info_mng.server.UserServer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServersImlp  {
    @Resource
    private UserMappers zyuserMapper;

//    @Override
//    public boolean addUser(Md md) throws Exception {
//        boolean fg = false;
//        if (zyuserMapper.UserAdd(md) > 0) {
//            fg = true;
//        }
//        return fg;
//    }

//    @Override
//    public boolean updateUser(Md md) throws Exception {
//        boolean fg = false;
//        if (zyuserMapper.UserUpdate(md) > 0) {
//            fg = true;
//        }
//        return fg;
//    }

//    @Override
//    public Md findUserbyId(Integer uid) throws Exception {
//        return zyuserMapper.findUserbyId(uid);
//    }

//    @Override
//    public boolean deluser(int id) throws Exception {
//        boolean fg = false;
//        if (zyuserMapper.deluser(id) > 0) {
//            fg = true;
//        }
//        return fg;
//    }




    public List<Userss> findUserList(String uName) throws Exception {
        return zyuserMapper.findUserName (uName);
    }

    public Userss findUserPwdbyUname(String uName, String uPassWord) throws Exception {
        List<Userss> list = zyuserMapper.findUserName(uName);
        if (list != null) {
            Userss m = list.get(0);
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
