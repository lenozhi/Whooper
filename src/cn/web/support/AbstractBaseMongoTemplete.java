/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author joephoenix
 */
public class AbstractBaseMongoTemplete implements ApplicationContextAware {

    protected MongoTemplate mongoTemplate;

    /**
     * 设置mongoTemplate
     *
     * @param mongoTemplate the mongoTemplate to set
     */
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        MongoTemplate mongoTemplate = applicationContext.getBean("mongoTemplate", MongoTemplate.class);
        setMongoTemplate(mongoTemplate);
    }
}
