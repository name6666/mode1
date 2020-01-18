package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.SuperUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface SuperUserMapper extends Mapper<SuperUser> {
    public SuperUser findSuperUserName(String username) throws Exception;

//    public int superUserAdd(SuperUser superUser) throws Exception;

    public List<SuperUser> findSuperUserAllbyUname(String sName) throws Exception;
}
