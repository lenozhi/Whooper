/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.dao;

import com.web.domain.Userinfo;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joephoenix
 */
@Repository("userinfoDao")
@Transactional
public class UserinfoDao {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;
    protected static Logger logger = Logger.getLogger("repository");

    /**
     * 查找所有的用户信息
     *
     * @return
     */
    public List<Userinfo> findAll() {
        return mongoTemplate.find(new Query(), Userinfo.class);
    }

    /**
     * 按照email查询用户
     *
     * @param regex
     * @return
     */
    public List<Userinfo> findByRegex(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria("email").regex(pattern.toString());
        return mongoTemplate.find(new Query(criteria), Userinfo.class);
    }

    /**
     * 按照id查询
     *
     * @param id
     * @return
     */
    public Userinfo findOne(String id) {
        return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Userinfo.class);
    }

    /**
     * 插入一个新的用户
     *
     * @param userinfo new user information
     */
    public void insert(Userinfo userinfo) {
        mongoTemplate.insert(userinfo);
    }

    /**
     * 删除所有的用户信息 不建议使用
     */
    public void removeAll() {
        List<Userinfo> list = this.findAll();
        if (list != null) {
            for (Userinfo ui : list) {
                mongoTemplate.remove(ui);
            }
        }
    }

    /**
     * 按照Id删除一个用户
     *
     * 建议使用
     *
     * @param id
     */
    public void removeOne(String id) {
        Criteria criteria = Criteria.where("id").in(id);
        if (criteria == null) {
            Query query = new Query(criteria);
            if (null != query && mongoTemplate.findOne(query, Userinfo.class) != null) {
                mongoTemplate.remove(mongoTemplate.findOne(query, Userinfo.class));
            }
        }
    }
}
