/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.domain;

import java.io.Serializable;

/**
 *
 * @author joephoenix
 */
public class UsersFans implements Serializable {

    private static final long serialVersionUID = -5785877964397911259L;
    private String id;
    private String mainEmail;
    private String fans;

    public UsersFans() {
    }

    public UsersFans(String id, String mainemail, String fans) {
        this.id = id;
        this.mainEmail = mainemail;
        this.fans = fans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainEmail() {
        return mainEmail;
    }

    public void setMainEmail(String mainEmail) {
        this.mainEmail = mainEmail;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }
}
