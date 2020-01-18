package net.jhc.app_info_mng.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * user实体类
 *
 * @author jhc
 */
@Data
@Table(name = "sys_user")
public class User implements Serializable {

    @Id
    private Integer uid;//客户编号


    @Column(name = "uName")
    private String uName;//客户姓名
    @Column(name = "uPassWord")
    private String uPassWord;//客户密码


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUName() {
        return uName;
    }

    public void setUName(String uName) {
        this.uName = uName;
    }

    public String getUPassWord() {
        return uPassWord;
    }

    public void setUPassWord(String uPassWord) {
        this.uPassWord = uPassWord;
    }

}
