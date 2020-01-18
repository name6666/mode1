package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.FruitInformation;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface FruitInformationMapper extends Mapper<FruitInformation> {
//    public int FrontAdd(FruitInformation fruitInformation) throws Exception;
//
//    public FruitInformation findFrontNamebyId(Integer fid) throws Exception;
//    @Select("SELECT * FROM order_information where ")
    public List<FruitInformation> findUserFrontbyUname(String fName) throws Exception;
//
//    public int FrontUpdate(FruitInformation fruitInformation) throws Exception;
//
//    public int delFront(Integer fid) throws Exception;
}
