package net.jhc.app_info_mng.server;

import net.jhc.app_info_mng.pojo.SuperUser;

import java.util.List;

public interface SuperUserServer {

    /**新增*/
    public boolean addUser(SuperUser superUser) throws Exception;

    public SuperUser findUserPwdbyUname(String sName, String sPassword) throws Exception;

    public List<SuperUser> findSuperUserAllbyUname(String oName) throws Exception;

}
