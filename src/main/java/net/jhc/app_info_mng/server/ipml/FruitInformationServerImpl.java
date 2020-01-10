package net.jhc.app_info_mng.server.ipml;

import net.jhc.app_info_mng.dao.FruitInformationMapper;
import net.jhc.app_info_mng.pojo.FruitInformation;
import net.jhc.app_info_mng.server.FruitInformationServer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FruitInformationServerImpl implements FruitInformationServer {
    @Resource
    private FruitInformationMapper fruitInformationMapper;

    @Override
    public boolean addFruit(FruitInformation fruitInformation) throws Exception {
        boolean fg = false;
        if (fruitInformationMapper.FrontAdd(fruitInformation) > 0) {
            fg = true;
        }
        return fg;
    }

    @Override
    public boolean delFruit(int fid) throws Exception {
        boolean fg = false;
        if (fruitInformationMapper.delFront(fid) > 0) {
            fg = true;
        }
        return fg;
    }

    @Override
    public boolean updateFruit(FruitInformation fruitInformation) throws Exception {
        boolean fg = false;
        if (fruitInformationMapper.FrontUpdate(fruitInformation) > 0) {
            fg = true;
        }
        return fg;
    }

    @Cacheable(cacheNames = {"findFruitList"})
    @Override
    public List<FruitInformation> findFruitList(String fName) throws Exception {
        return fruitInformationMapper.findUserFrontbyUname(fName);
    }

    @Cacheable(cacheNames = {"findFruitbyId"})
    @Override
    public FruitInformation findFruitbyId(Integer fid) throws Exception {
        return fruitInformationMapper.findFrontNamebyId(fid);
    }
}
