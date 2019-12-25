package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.Md;

import java.util.List;

public interface UserMapper {
    public List<Md> findUserName(String uName) throws Exception;

    public int UserAdd(Md md) throws Exception;

    public int deluser(int uid) throws Exception;

    public Md findUserbyId(int uid) throws Exception;

    public int UserUpdate(Md md) throws Exception;
}
