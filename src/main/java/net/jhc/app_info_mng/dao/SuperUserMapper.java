package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.SuperUser;

import java.util.List;

public interface SuperUserMapper {
    public SuperUser findSuperUserName(String username) throws Exception;

    public int superUserAdd(SuperUser superUser) throws Exception;

    public List<SuperUser> findSuperUserAllbyUname(String sName) throws Exception;
}
