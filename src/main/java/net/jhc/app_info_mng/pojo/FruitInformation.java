package net.jhc.app_info_mng.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "fruit_information")
public class FruitInformation implements Serializable {
    @Id
    private Integer fid;

    @Column(name = "fName")
    public String fName;
    @Column(name = "fWeight")
    private Integer fWeight;
    @Column(name = "fPrice")
    private Integer fPrice;
    @Column(name = "fInventory")
    private Integer fInventory;
    @Column(name = "fimg")
    private String fimg;

    public Integer getFid() {
        return fid;
    }

    public String getfName() {
        return fName;
    }

    public Integer getfWeight() {
        return fWeight;
    }

    public Integer getfPrice() {
        return fPrice;
    }

    public Integer getfInventory() {
        return fInventory;
    }

    public String getFimg() {
        return fimg;
    }

}
