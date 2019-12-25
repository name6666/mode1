package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.Userss;

import java.util.List;

public interface UserMappers {
    public List<Userss> findUserName(String username) throws Exception;

    public Userss findUserbyId(int uid) throws Exception;

}
