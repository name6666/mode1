package net.jhc.app_info_mng.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * userinfo实体类
 *
 * @author jhc
 */
@Data
@Table(name = "user_info")
public class Userinfo implements Serializable {

    @Id
    private Integer uLg;//客户编号


    @Column(name = "iName")
    private String iName;//客户姓名

    public Integer getULg() {
        return uLg;
    }

    public void setULg(Integer uLg) {
        this.uLg = uLg;
    }

    public String getIName() {
        return iName;
    }

    public void setIName(String iName) {
        this.iName = iName;
    }


}
