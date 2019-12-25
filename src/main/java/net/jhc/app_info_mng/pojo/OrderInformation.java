package net.jhc.app_info_mng.pojo;

import lombok.Data;

@Data
public class OrderInformation {
    private int oid,oNumber,oPrice;

    public int getoNumber() {
        return oNumber;
    }

    public int getoPrice() {
        return oPrice;
    }

    private String oName,oAddress,oFruit;

}
