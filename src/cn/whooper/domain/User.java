/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 *
 * @author joephoenix 2013-3-26
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long U_ID;
    //邮箱
    private String email;
    //密码
    private String password;
    //账号类型
    private Integer accounttype;

    public Long getU_ID() {
        return U_ID;
    }

    public void setU_ID(Long U_ID) {
        this.U_ID = U_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }
}
