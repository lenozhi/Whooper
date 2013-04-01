/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.whooper.domain.Alarm;
import cn.whooper.domain.Page;

/**
 * 处理的控制器
 *
 * @author joephoenix
 */
@Controller
@Component
public class NoticeController {

    protected static Logger logger = Logger.getLogger("controller");
   
    
   // @RequestMapping(value = "/u{id}", method = RequestMethod.GET)
    @RequestMapping(value="/list/{p}")
    public String IndexPage(@PathVariable Integer p,Model model) {
    	List l = new ArrayList();
    	for (int i=(p-1)*Page.RECORD_PER_PAGE; i<p*Page.RECORD_PER_PAGE; i++){
    		Alarm a = new Alarm();
    		a.setId(i+"");
    		a.setTitle("tasfasdfasdf"+i);
    		l.add(a);
    	}
    	
    	Page page = new Page();
    	page.setData(l);
    	
    	model.addAttribute("notices", l);
    	model.addAttribute("page", page.getPages(p));
        return "u/notice-list";
    }

    @RequestMapping(value="/test")
    public String test(){
    	return "u/test";
    }
}
