package net.jhc.app_info_mng.server;

import net.jhc.app_info_mng.pojo.OrderInformation;

import java.util.List;

public interface OrderInformationServer {

    public boolean addOrder(OrderInformation orderInformation) throws Exception;

    public boolean delOrder(Integer oid)throws Exception;

    public List<OrderInformation> findOrderList(String oFruit,String oName)throws Exception;

    public OrderInformation findOrderNamebyId(Integer oid) throws Exception;

    public boolean updateOrder(OrderInformation orderInformation) throws Exception;

}
