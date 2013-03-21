/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web.controller;

import com.web.domain.Noticecontext;
import com.web.service.NoticeDealService;
import com.web.service.UserInfoService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author joephoenix
 */
@Controller
//@RequestMapping("/user")
@Component
public class UserDealController {

    protected static Logger logger = Logger.getLogger("controller");
    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;
    @Resource(name = "noticeDealService")
    private NoticeDealService noticeDealService;

    @RequestMapping("/userinfo")
    public String viewUserInfo(Model model) {
        String email = "joe_phoenix@163.com";
        Map<String, String> m_user = userInfoService.getUserRealitionship(email);
        List<Noticecontext> l_context = noticeDealService.findUserNotice(email);
        model.addAttribute("user", m_user.get("idenfity"));
        model.addAttribute("watches", m_user.get("links"));
        model.addAttribute("fans", m_user.get("fans"));
        model.addAttribute("contexts", l_context);
        return "userpage";
    }
}
