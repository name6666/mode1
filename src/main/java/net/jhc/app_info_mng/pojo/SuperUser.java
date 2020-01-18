package net.jhc.app_info_mng.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "super_user")
public class SuperUser implements Serializable {
    @Id
    private int sid;

    @Column(name = "sName")
    private String sName;
    @Column(name = "sPassword")
    private String sPassword;

}
