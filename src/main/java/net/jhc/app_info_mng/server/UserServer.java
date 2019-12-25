package net.jhc.app_info_mng.server;

import net.jhc.app_info_mng.pojo.Md;
import net.jhc.app_info_mng.pojo.Userss;

import java.util.List;

public interface UserServer {
    public boolean addUser(Md md) throws Exception;

    public boolean deluser(int id) throws Exception;

    public List<Md> findUserList(String uName) throws Exception;

    public Md findUserPwdbyUname(String uName, String uPassWord) throws Exception;

    public boolean updateUser(Md md) throws Exception;

    public Md findUserbyId(Integer uid) throws Exception;
}
