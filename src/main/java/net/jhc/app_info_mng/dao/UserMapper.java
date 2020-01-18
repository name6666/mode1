package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    public List<User> findUserName(String uName) throws Exception;
//
//    public int UserAdd(User md) throws Exception;
//
//    public int deluser(int uid) throws Exception;
//
//    public User findUserbyId(int uid) throws Exception;
//
//    public int UserUpdate(User md) throws Exception;
}
