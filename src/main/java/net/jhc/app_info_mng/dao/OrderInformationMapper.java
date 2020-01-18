package net.jhc.app_info_mng.dao;

import net.jhc.app_info_mng.pojo.OrderInformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@org.apache.ibatis.annotations.Mapper
public interface OrderInformationMapper extends Mapper<OrderInformation> {
//    public int OrderAdd(OrderInformation orderInformation) throws Exception;
//
//    public OrderInformation findOrderNamebyId(Integer oid) throws Exception;
//
    public List<OrderInformation> findOrderByoPrice(@Param(value = "oFruit")String oPrice,@Param(value = "oName")String oName) throws Exception;
//
//    public int OrderUpdate(OrderInformation orderInformation) throws Exception;
//
//    public int delOrder(@Param(value = "oid")Integer oid) throws Exception;


}
