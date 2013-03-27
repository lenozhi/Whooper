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
public class NoticeLinkStatus implements Serializable {

    private static final long serialVersionUID = -5785857960597911259L;
    private String id;
    private String noticeId;
    private String targetEmail;
    private String status;

    public NoticeLinkStatus() {
    }

    public NoticeLinkStatus(String id, String noticeid, String targetemail, String status) {
        this.id = id;
        this.noticeId = noticeid;
        this.targetEmail = targetemail;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getTargetEmail() {
        return targetEmail;
    }

    public void setTargetEmail(String targetEmail) {
        this.targetEmail = targetEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
