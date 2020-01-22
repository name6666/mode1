package net.jhc.app_info_mng.server;


import net.jhc.app_info_mng.pojo.FruitInformation;

import java.util.List;

public interface FruitInformationServer {
    public boolean addFruit(FruitInformation fruitInformation) throws Exception;

    public boolean delFruit(int fid) throws Exception;

    public boolean updateFruit(FruitInformation fruitInformation) throws Exception;

    public List<FruitInformation> findFruitList(String fName) throws Exception;

    public FruitInformation findFruitbyId(Integer fid) throws Exception;
    public List<FruitInformation> findAll();
}
