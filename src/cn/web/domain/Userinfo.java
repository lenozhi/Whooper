/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.domain;

import java.io.Serializable;

/**
 *
 * @author joephoenix
 */
public class Userinfo implements Serializable {

    private static final long serialVersionUID = -8333984959658544635L;
    //字段内容
    private String id;
    private String email;
    private String sex;
    private String nikename;

    public Userinfo() {
    }

    public Userinfo(String id, String email, String sex, String nikename) {
        this.id = id;
        this.email = email;
        this.sex = sex;
        this.nikename = nikename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }
}
