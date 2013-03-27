/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.dao;

import cn.web.domain.NoticeLinkStatus;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import javax.annotation.Resource;
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
@Repository("noticeLinkStatusDao")
@Transactional
public class NoticeLinkStatusDao {

    @Resource(name = "mongoTemplate")
    private MongoTemplate mongoTemplate;
    //log record
    protected static Logger logger = Logger.getLogger("repository");

    /**
     * 取得所有的通知提醒的链接关系
     *
     * @return
     */
    public List<NoticeLinkStatus> findAll() {
        return mongoTemplate.find(new Query(), NoticeLinkStatus.class);
    }

    /**
     * 按照推送的用户的状态，查找相应的推送状态
     *
     * @param targetEmail
     * @return
     */
    public List<NoticeLinkStatus> getOneLinkByTarget(String targetEmail) {
        Pattern pattern = Pattern.compile(targetEmail, Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria("targetEmail").regex(pattern.toString());
        return mongoTemplate.find(new Query(criteria), NoticeLinkStatus.class);
    }

    /**
     * 按照id查询一条信息
     *
     * @param id
     * @return
     */
    public NoticeLinkStatus findOneStatus(String id) {
        return (NoticeLinkStatus) mongoTemplate.findById(id, NoticeLinkStatus.class);
    }

    /**
     * 插入一条新数据
     *
     * @param noticeLinkStatus
     */
    public void insertLinkStatus(NoticeLinkStatus noticeLinkStatus) {
        mongoTemplate.insert(noticeLinkStatus);
    }

    /**
     * 修改一条状态数据
     *
     * @param nls
     */
    public void updateById(NoticeLinkStatus nls) {
        Criteria criteria = Criteria.where("id").is(nls.getId());
        Query query = new Query(criteria);
        Update update = Update.update("id", nls.getId()).
                addToSet("targetEmail", nls.getTargetEmail()).
                addToSet("status", nls.getStatus());
        mongoTemplate.updateFirst(query, update, NoticeLinkStatus.class);
    }
}
