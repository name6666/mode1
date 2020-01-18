package net.jhc.app_info_mng.server.ipml;

import net.jhc.app_info_mng.dao.OrderInformationMapper;
import net.jhc.app_info_mng.pojo.OrderInformation;
import net.jhc.app_info_mng.server.OrderInformationServer;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderInformationServerImpl implements OrderInformationServer {
    @Resource
    private OrderInformationMapper orderInformationMapper;

    @Override
    public boolean addOrder(OrderInformation orderInformation) throws Exception {
        boolean fg = false;
        if (orderInformationMapper.insertSelective(orderInformation) > 0) {
            fg = true;
        }
        return fg;
    }

    @Override
    public boolean delOrder(Integer oid) throws Exception {
        boolean fg = false;
        if (orderInformationMapper.deleteByPrimaryKey(oid) > 0) {
            fg = true;
        }
        return fg;
    }
//    @Cacheable(cacheNames = {"findOrderList"})
    @Override
    public List<OrderInformation> findOrderList(String oPrice,String oName) throws Exception {
        OrderInformation information=new OrderInformation();
        return orderInformationMapper.findOrderByoPrice(oPrice,oName);
    }

//    @Cacheable(cacheNames = {"findOrderNamebyId"})
    @Override
    public  OrderInformation findOrderNamebyId(Integer oid) throws Exception {
        return orderInformationMapper.selectByPrimaryKey(oid);
    }

    @Override
    public boolean updateOrder(OrderInformation orderInformation) throws Exception {
        boolean fg = false;
        if (orderInformationMapper.updateByPrimaryKeySelective(orderInformation) > 0) {
            fg = true;
        }
        return fg;
    }


}
