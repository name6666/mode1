package net.jhc.app_info_mng.server;

import net.jhc.app_info_mng.pojo.User;

import java.util.List;

public interface UserServer {
    public boolean addUser(User md) throws Exception;

    public boolean deluser(int id) throws Exception;

    public List<User> findUserList(String uName) throws Exception;

    public User findUserPwdbyUname(String uName, String uPassWord) throws Exception;

    public boolean updateUser(User md) throws Exception;

    public User findUserbyId(Integer uid) throws Exception;
}
