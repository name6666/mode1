package net.jhc.app_info_mng.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * information实体类
 *
 * @author jhc
 */
@Data
@Table(name = "order_information")
public class OrderInformation implements Serializable {

    @Id
    private Integer oid;//订单编号(主键)

    @Column(name = "oName")
    private String oName;//买家名字
    @Column(name = "oAddress")
    private String oAddress;//收货地址
    @Column(name = "oFruit")
    private String oFruit;//购买水果
    @Column(name = "oPrice")
    private Integer oPrice;//金额
    @Column(name = "oNumber")
    private Integer oNumber;//水果数量


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOName() {
        return oName;
    }

    public void setOName(String oName) {
        this.oName = oName;
    }

    public String getOAddress() {
        return oAddress;
    }

    public void setOAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getOFruit() {
        return oFruit;
    }

    public void setOFruit(String oFruit) {
        this.oFruit = oFruit;
    }

    public Integer getOPrice() {
        return oPrice;
    }

    public void setOPrice(Integer oPrice) {
        this.oPrice = oPrice;
    }

    public Integer getONumber() {
        return oNumber;
    }

    public void setONumber(Integer oNumber) {
        this.oNumber = oNumber;
    }


}
