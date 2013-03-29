/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * 提醒、通知或者日记的基础属性
 *
 * @author joephoenix
 */
@Entity
@Table(name = "alarm")
public class AlarmObject implements Serializable {

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    private Integer AID;
    @Column(name = "TITLE")
    private String TITLE;
    @Column(name = "CONTENT")
    private String CONTENT;
    @Column(name = "AUTHOR")
    private String AUTHOR;
    @Column(name = "CREATETIME", columnDefinition = "TIMESTAMP", insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date CREATETIME;
    @Column(name = "ALARM_TYPE")
    private Integer ALARM_TYPE;
    @Column(name = "ALARM_DAY", columnDefinition = "DATE", insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date ALARM_DAY;
    @Column(name = "ALARM_TIME", columnDefinition = "TIME", insertable = true, updatable = true)
    @Temporal(TemporalType.TIME)
    private Date ALARM_TIME;
    @Column(name = "STATUS")
    private Integer STATUS;

    public Integer getAID() {
        return AID;
    }

    public void setAID(Integer AID) {
        this.AID = AID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public void setAUTHOR(String AUTHOR) {
        this.AUTHOR = AUTHOR;
    }

    public Date getCREATETIME() {
        return CREATETIME;
    }

    public void setCREATETIME(Date CREATETIME) {
        this.CREATETIME = CREATETIME;
    }

    public Integer getALARM_TYPE() {
        return ALARM_TYPE;
    }

    public void setALARM_TYPE(Integer ALARM_TYPE) {
        this.ALARM_TYPE = ALARM_TYPE;
    }

    public Date getALARM_DAY() {
        return ALARM_DAY;
    }

    public void setALARM_DAY(Date ALARM_DAY) {
        this.ALARM_DAY = ALARM_DAY;
    }

    public Date getALARM_TIME() {
        return ALARM_TIME;
    }

    public void setALARM_TIME(Date ALARM_TIME) {
        this.ALARM_TIME = ALARM_TIME;
    }

    public Integer getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(Integer STATUS) {
        this.STATUS = STATUS;
    }
}
