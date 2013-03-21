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
public class Noticecontext implements Serializable {

    private static final long serialVersionUID = -5765857960597911259L;
    private String id;
    private String email;
    private String msgName;
    private String msgContext;
    private String createStamp;
    private String noticeStamp;
    private String expireSign;
    private String noticeType;
    private String foreTime;

    public Noticecontext() {
    }

    public Noticecontext(String id, String email, String msgname, String msgcontext, String createstamp,
            String noticestamp, String expiresign, String noticetype, String foretime) {
        this.id = id;
        this.email = email;
        this.msgName = msgname;
        this.msgContext = msgcontext;
        this.createStamp = createstamp;
        this.noticeStamp = noticestamp;
        this.expireSign = expiresign;
        this.noticeType = noticetype;
        this.foreTime = foretime;
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

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgContext() {
        return msgContext;
    }

    public void setMsgContext(String msgContext) {
        this.msgContext = msgContext;
    }

    public String getCreateStamp() {
        return createStamp;
    }

    public void setCreateStamp(String createStamp) {
        this.createStamp = createStamp;
    }

    public String getNoticeStamp() {
        return noticeStamp;
    }

    public void setNoticeStamp(String noticeStamp) {
        this.noticeStamp = noticeStamp;
    }

    public String getExpireSign() {
        return expireSign;
    }

    public void setExpireSign(String expireSign) {
        this.expireSign = expireSign;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getForeTime() {
        return foreTime;
    }

    public void setForeTime(String foreTime) {
        this.foreTime = foreTime;
    }
}
