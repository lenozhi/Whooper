/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.dao;

import cn.web.domain.UserInfo;
import cn.web.support.AbstractBaseMongoTemplete;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * 此类是另外一种调用MongoTemplete
 *
 * 然后执行数据库操作的类
 *
 * 暂时不使用
 *
 * @deprecated
 *
 * @author joephoenix
 */
@Repository("userInfoDao")
@Transactional
public class UeseInfoDao extends AbstractBaseMongoTemplete {

    protected static Logger logger = Logger.getLogger("repository");

    /**
     * 新增
     *
     * @param UserInfo 用户信息对象
     */
    public void insert(UserInfo user) {
        mongoTemplate.insert(user);
    }

    /**
     * 删除,按主键id, 如果主键的值为null,删除会失败
     *
     * 不建议使用
     *
     * @param id
     */
    public void deleteById(String id) {
        UserInfo user = new UserInfo(id, null, null, null);
        mongoTemplate.remove(user);
    }

    /**
     * 按照用户的电子邮箱信息为条件删除
     *
     * 不建议使用
     *
     * @param criteriaUser
     */
    public void delete(UserInfo exisUser) {
        Criteria criteria = Criteria.where("email").gt(exisUser.getEmail());
        Query query = new Query(criteria);
        mongoTemplate.remove(query, UserInfo.class);
    }

    /**
     * 按主键修改, 如果文档中没有相关key会新增
     *
     * 使用$set修改器
     *
     * @param updateUserInfo 修改的用户信息
     */
    public void updateById(UserInfo updateUserInfo) {
        Criteria criteria = Criteria.where("id").is(updateUserInfo.getId());
        Query query = new Query(criteria);
        Update update = Update.update("email", updateUserInfo.getEmail()).
                set("nikname", updateUserInfo.getNikename()).
                set("sex", updateUserInfo.getSex());
        mongoTemplate.updateFirst(query, update, UserInfo.class);
    }

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    public UserInfo findById(String id) {
        return mongoTemplate.findById(id, UserInfo.class);
    }

    /**
     * 查询全部
     *
     * @return
     */
    public List<UserInfo> findAll() {
        return mongoTemplate.findAll(UserInfo.class);
    }

    /**
     * 按条件查询, 分页
     *
     * @param criteriaUser
     * @param skip
     * @param limit
     * @return
     */
    public List<UserInfo> find(UserInfo criteriaUser, int skip, int limit) {
        Query query = getQuery(criteriaUser);
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query, UserInfo.class);
    }

    /**
     * 统计所有的数据的总数
     *
     * @param userinfo
     * @return
     */
    public long count(UserInfo userinfo) {
        Query query = getQuery(userinfo);
        return mongoTemplate.count(query, UserInfo.class);
    }

    /**
     * 使用每个字段作为条件
     *
     * 查询符合各自条件的结果
     *
     * @param userinfo
     * @return
     */
    private Query getQuery(UserInfo userinfo) {
        if (userinfo == null) {
            userinfo = new UserInfo();
        }
        Query query = new Query();
        if (userinfo.getId() != null) {
            Criteria criteria = Criteria.where("id").is(userinfo.getId());
            query.addCriteria(criteria);
        }
        if (userinfo.getSex() != null) {
            Criteria criteria = Criteria.where("sex").gt(userinfo.getSex());
            query.addCriteria(criteria);
        }
        if (userinfo.getEmail() != null) {
            Criteria criteria = Criteria.where("email").gt(userinfo.getEmail());
            query.addCriteria(criteria);
        }
        if (userinfo.getNikename() != null) {
            Criteria criteria = Criteria.where("nikename").regex(userinfo.getNikename());
            query.addCriteria(criteria);
        }
        return query;
    }
}
