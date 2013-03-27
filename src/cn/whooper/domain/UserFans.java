/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户的粉丝
 *
 * @author joephoenix
 */
@Entity
@Table(name = "user_fans")
public class UserFans implements Serializable {

    @Id
    private String useremail;
    //用户的专注列表
    @Column(name = "fans")
    @Basic
    private byte[] fans;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public byte[] getFans() {
        return fans;
    }

    public void setFans(byte[] fans) {
        this.fans = fans;
    }
}
