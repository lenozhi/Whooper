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
public class UsersLink implements Serializable {

    private static final long serialVersionUID = -5785857964397911259L;
    private String id;
    private String mainEmail;
    private String linkEmail;

    public UsersLink() {
    }

    public UsersLink(String id, String mainemail, String linkemail) {
        this.id = id;
        this.mainEmail = mainemail;
        this.linkEmail = linkemail;
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

    public String getLinkEmail() {
        return linkEmail;
    }

    public void setLinkEmail(String linkEmail) {
        this.linkEmail = linkEmail;
    }
}
