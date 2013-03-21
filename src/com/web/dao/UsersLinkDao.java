/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.web.domain.UsersLink;
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
@Repository("usersLinkDao")
@Transactional
public class UsersLinkDao {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;
    //log record
    protected static Logger logger = Logger.getLogger("repository");

    /**
     * 查找所有的关系
     *
     * @return
     */
    public List<UsersLink> findAll() {
        return mongoTemplate.find(new Query(), UsersLink.class);
    }

    /**
     * 按照用户的email信息，查询用户的关系，如关注
     *
     * @param mainEmail
     * @return
     */
    public UsersLink findByMainEmail(String mainEmail) {
        Pattern pattern = Pattern.compile(mainEmail, Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria("mainEmail").regex(pattern.toString());
        return (UsersLink) mongoTemplate.find(new Query(criteria), UsersLink.class).get(0);
    }

    /**
     * 查找id查找用户对应的关注列表
     *
     * @param id
     * @return
     */
    public UsersLink findById(String id) {
        return (UsersLink) mongoTemplate.findById(id, UsersLink.class);
    }

    /**
     * 插入一条新的关注关系
     *
     * @param usersLink
     */
    public void insertLink(UsersLink usersLink) {
        mongoTemplate.insert(usersLink);
    }

    /**
     * 修改一个关注关系表
     *
     * @param usersLink
     */
    public void updateLink(UsersLink usersLink) {
        Criteria criteria = Criteria.where("id").is(usersLink.getId());
        Query query = new Query(criteria);
        Update update = Update.update("id", usersLink.getId()).
                addToSet("linkEmail", usersLink.getLinkEmail());
        mongoTemplate.updateFirst(query, update, UsersLink.class);
    }

    /**
     * 修改用户的注册Email
     *
     * @param usersLink
     */
    public void modifyUserEmail(UsersLink usersLink) {
        Criteria criteria = Criteria.where("id").is(usersLink.getId());
        Query query = new Query(criteria);
        Update update = Update.update("id", usersLink.getId()).
                addToSet("mainEmail", usersLink.getMainEmail());
        mongoTemplate.updateFirst(query, update, UsersLink.class);
    }
}
