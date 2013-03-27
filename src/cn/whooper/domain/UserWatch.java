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
 * 用户的关注
 *
 * @author joephoenix
 */
@Entity
@Table(name = "user_watch")
public class UserWatch implements Serializable {

    @Id
    private String useremail;
    //用户的专注列表
    @Column(name = "watches")
    @Basic
    private byte[] watches;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public byte[] getWatches() {
        return watches;
    }

    public void setWatches(byte[] watches) {
        this.watches = watches;
    }
}
