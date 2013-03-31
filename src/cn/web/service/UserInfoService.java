/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.web.service;

import cn.web.dao.UserinfoDao;
import cn.web.dao.UsersFansDao;
import cn.web.dao.UsersLinkDao;
import cn.web.domain.UserInfo;
import cn.web.domain.UsersFans;
import cn.web.domain.UsersLink;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author joephoenix
 */
@Service("userInfoService")
@Transactional
public class UserInfoService {

    protected static Logger logger = Logger.getLogger("service");
    @Resource(name = "userinfoDao")
    private UserinfoDao userinfoDao;
    @Resource(name = "usersFansDao")
    private UsersFansDao usersFansDao;
    @Resource(name = "usersLinkDao")
    private UsersLinkDao usersLinkDao;

    /**
     * *********** 用户信息处理的方法 *****************
     */
    /**
     * 添加一个新用户
     *
     * @param user
     */
    public void insertUserInfo(UserInfo user) {
        userinfoDao.insert(user);
    }

    /**
     * 添加一个新用户的所有关注
     *
     * @param link
     */
    public void insertUserLinks(UsersLink link) {
        usersLinkDao.insertLink(link);
    }

    /**
     * 添加一个新用户的所有粉丝
     *
     * @param fans
     */
    public void insertUserFans(UsersFans fans) {
        usersFansDao.insertLink(fans);
    }

    /**
     * 读取一个用户的信息、关注和粉丝
     *
     * @param email
     * @return
     */
    public Map<String, String> getUserRealitionship(String email) {
        Map<String, String> m_realitionShip = new HashMap<String, String>();
        m_realitionShip.put("idenfity", email);
        m_realitionShip.put("links", usersLinkDao.findByMainEmail(email).getLinkEmail());
        m_realitionShip.put("fans", usersFansDao.findByMainEmail(email).getFans());
        return m_realitionShip;
    }
}
