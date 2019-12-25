package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.FruitInformation;

import java.util.List;

public interface FruitInformationMapper {
    public int FrontAdd(FruitInformation fruitInformation) throws Exception;

    public FruitInformation findFrontNamebyId(Integer fid) throws Exception;

    public List<FruitInformation> findUserFrontbyUname(String fName) throws Exception;

    public int FrontUpdate(FruitInformation fruitInformation) throws Exception;

    public int delFront(Integer fid) throws Exception;
}
