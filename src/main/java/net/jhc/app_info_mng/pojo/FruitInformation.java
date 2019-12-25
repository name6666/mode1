package net.jhc.app_info_mng.pojo;

import lombok.Data;

@Data
public class FruitInformation {
    private int fid,fInventory;

    public int getfInventory() {
        return fInventory;
    }

    public int getfPrice() {
        return fPrice;
    }

    private String fName,fimg;
    private int fPrice, fWeight;
}
