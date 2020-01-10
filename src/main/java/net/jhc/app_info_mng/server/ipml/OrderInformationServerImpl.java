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
        if (orderInformationMapper.OrderAdd(orderInformation) > 0) {
            fg = true;
        }
        return fg;
    }

    @Override
    public boolean delOrder(Integer oid) throws Exception {
        boolean fg = false;
        if (orderInformationMapper.delOrder(oid) > 0) {
            fg = true;
        }
        return fg;
    }
    @Cacheable(cacheNames = {"findOrderList"})
    @Override
    public List<OrderInformation> findOrderList(String oPrice,String oName) throws Exception {
        System.out.println("6666666666666666666666666");
        return orderInformationMapper.findOrderByoPrice(oPrice,oName);
    }

    @Cacheable(cacheNames = {"findOrderNamebyId"})
    @Override
    public  OrderInformation findOrderNamebyId(Integer oid) throws Exception {
        return orderInformationMapper.findOrderNamebyId(oid);
    }

    @Override
    public boolean updateOrder(OrderInformation orderInformation) throws Exception {
        boolean fg = false;
        if (orderInformationMapper.OrderUpdate(orderInformation) > 0) {
            fg = true;
        }
        return fg;
    }


}
