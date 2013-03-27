/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.service;

import cn.whooper.domain.User;
import cn.whooper.domain.UserFans;
import cn.whooper.domain.UserWatch;
import cn.whooper.repository.UserFansRepository;
import cn.whooper.repository.UserRepository;
import cn.whooper.repository.UserWatchRepository;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务实现类
 *
 * @author joephoenix
 */
@Service("userService")
public class UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;
    @Resource(name = "userWatchRepository")
    private UserWatchRepository userWatchRepository;
    @Resource(name = "userFansRepository")
    private UserFansRepository userFansRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Transactional
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public UserWatch findByEmailToWatch(String email) {
        return userWatchRepository.findByUseremail(email);
    }

    @Transactional
    public UserFans findByEmailToFans(String email) {
        return userFansRepository.findByUseremail(email);
    }

    public Map<String, String> getUserRealitionship(String email) {
        Map<String, String> m_realitionShip = new HashMap<String, String>();
        m_realitionShip.put("idenfity", findByEmail(email).getU_ID().toString());
        m_realitionShip.put("userfrom", setUserFrom(findByEmail(email).getAccounttype()));
        m_realitionShip.put("links", findByEmailToWatch(email).getWatches().toString());
        m_realitionShip.put("fans", new String(findByEmailToFans(email).getFans()));
        return m_realitionShip;
    }

    /**
     * 设置用户来源的类型，
     *
     * 暂时有腾讯、新浪、百度等
     *
     * @param accounttype
     * @return
     */
    public String setUserFrom(Integer accounttype) {
        switch (accounttype) {
            case 1:
                return "新浪";
            case 2:
                return "腾讯";
            case 3:
                return "百度";
            default:
                return "新浪";
        }
    }
}
