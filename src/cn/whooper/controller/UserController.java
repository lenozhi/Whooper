/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.controller;

import cn.whooper.service.AlarmInfoService;
import cn.whooper.service.UserService;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户处理的控制器
 *
 * @author joephoenix
 */
@Controller
@Component
public class UserController {

    protected static Logger logger = Logger.getLogger("controller");
    @Resource(name = "userService")
    private UserService userService;
    @Resource(name = "alarmInfoService")
    private AlarmInfoService alarmInfoService;

    @RequestMapping("/userview")
    public String viewUserInfo(Model model) {
        String email = "joe_phoenix@163.com";
        Map<String, String> m_user = userService.getUserRealitionship(email);
        model.addAttribute("user", email);
        model.addAttribute("id", m_user.get("idenfity"));
        model.addAttribute("userfrom", m_user.get("userfrom"));
        model.addAttribute("watches", m_user.get("links"));
        model.addAttribute("fans", m_user.get("fans"));
        model.addAttribute("alarms", alarmInfoService.findInfoByAuthor(m_user.get("idenfity")));
        return "userpage";
    }
}
