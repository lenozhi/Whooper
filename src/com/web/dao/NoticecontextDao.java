/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.web.domain.Noticecontext;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joephoenix
 */
@Repository("noticecontextDao")
@Transactional
public class NoticecontextDao {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;
    //log record
    protected static Logger logger = Logger.getLogger("repository");

    /**
     * 查找所有的通知提醒
     *
     * @return
     */
    public List<Noticecontext> findAll() {
        return mongoTemplate.find(new Query(), Noticecontext.class);
    }

    /**
     * 以用户的email为条件，查询用户添加的提醒和通知
     *
     * @param useremail
     * @return
     */
    public List<Noticecontext> findNoticesByUser(String useremail) {
        Pattern pattern = Pattern.compile(useremail, Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria("email").regex(pattern.toString());
        return mongoTemplate.find(new Query(criteria), Noticecontext.class);
    }

    /**
     * 插入一条新数据
     *
     * @param notice
     */
    public void insertNotice(Noticecontext notice) {
        mongoTemplate.insert(notice);
    }

    /**
     * 修改一条通知的方法
     *
     * @param notice
     */
    public void updateById(Noticecontext notice) {
        Criteria criteria = Criteria.where("id").is(notice.getId());
        Query query = new Query(criteria);
        Update update = Update.update("msgName", notice.getMsgName()).
                addToSet("msgContext", notice.getMsgContext()).
                addToSet("noticestamp", notice.getNoticeStamp()).
                addToSet("noticeType", notice.getNoticeType()).
                addToSet("foretime", notice.getForeTime());
        mongoTemplate.updateFirst(query, update, Noticecontext.class);
    }

    /**
     * 设置一条通知的状态，是否过期
     *
     * @param id
     * @param expiresign
     */
    public void updateNoticeStatus(String id, String expiresign) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        Update update = Update.update("expireSign", expiresign);
        mongoTemplate.updateFirst(query, update, Noticecontext.class);
    }

    /**
     * 设置一条通知的提醒频率
     *
     * 1：每日；2，每周；3，每月；4，每年
     *
     * @param id
     * @param noticetype
     */
    public void updateNoticeCircle(String id, String noticetype) {
        Criteria criteria = Criteria.where("id").is(id);
        Query query = new Query(criteria);
        Update update = Update.update("noticeType", noticetype);
        mongoTemplate.updateFirst(query, update, Noticecontext.class);
    }
}
