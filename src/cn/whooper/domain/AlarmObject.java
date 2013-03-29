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
    @Column(name = "AID")
    private Integer aid;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "CREATETIME", columnDefinition = "TIMESTAMP", insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Column(name = "ALARM_TYPE")
    private Integer alarmType;
    @Column(name = "ALARM_DAY", columnDefinition = "DATE", insertable = true, updatable = true)
    @Temporal(TemporalType.DATE)
    private Date alarmDate;
    @Column(name = "ALARM_TIME", columnDefinition = "TIME", insertable = true, updatable = true)
    @Temporal(TemporalType.TIME)
    private Date alarmTime;
    @Column(name = "STATUS")
    private Integer status;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public Date getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Date alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
