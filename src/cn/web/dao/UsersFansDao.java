/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.dao;

import cn.web.domain.UsersFans;
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
@Repository("usersFansDao")
@Transactional
public class UsersFansDao {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;
    //log record
    protected static Logger logger = Logger.getLogger("repository");

    /**
     * 查找所有的关系
     *
     * @return
     */
    public List<UsersFans> findAll() {
        return mongoTemplate.find(new Query(), UsersFans.class);
    }

    /**
     * 按照用户的email信息，查询用户的关系，如关注
     *
     * @param mainEmail
     * @return
     */
    public UsersFans findByMainEmail(String mainEmail) {
        Pattern pattern = Pattern.compile(mainEmail, Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria("mainEmail").regex(pattern.toString());
        return (UsersFans) mongoTemplate.find(new Query(criteria), UsersFans.class).get(0);
    }

    /**
     * 查找id查找用户对应的关注列表
     *
     * @param id
     * @return
     */
    public UsersFans findById(String id) {
        return (UsersFans) mongoTemplate.findById(id, UsersFans.class);
    }

    /**
     * 插入一条新的关注关系
     *
     * @param usersLink
     */
    public void insertLink(UsersFans usersFans) {
        mongoTemplate.insert(usersFans);
    }

    /**
     * 修改一个关注关系表
     *
     * @param usersLink
     */
    public void updateLink(UsersFans usersFans) {
        Criteria criteria = Criteria.where("id").is(usersFans.getId());
        Query query = new Query(criteria);
        Update update = Update.update("id", usersFans.getId()).
                addToSet("fans", usersFans.getFans());
        mongoTemplate.updateFirst(query, update, UsersFans.class);
    }

    /**
     * 修改用户的注册Email
     *
     * @param usersLink
     */
    public void modifyUserEmail(UsersFans usersFans) {
        Criteria criteria = Criteria.where("id").is(usersFans.getId());
        Query query = new Query(criteria);
        Update update = Update.update("id", usersFans.getId()).
                addToSet("mainEmail", usersFans.getMainEmail());
        mongoTemplate.updateFirst(query, update, UsersFans.class);
    }
}
