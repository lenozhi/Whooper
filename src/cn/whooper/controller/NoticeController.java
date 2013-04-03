/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.whooper.domain.AlarmObject;
import cn.whooper.service.AlarmInfoService;

/**
 * 处理的控制器
 *
 * @author joephoenix
 */
@Controller
@Component
public class NoticeController {

	@Resource(name = "alarmInfoService")
	private AlarmInfoService alarmInfoService;
	
    protected static Logger logger = Logger.getLogger("controller");
   
    
   // @RequestMapping(value = "/u{id}", method = RequestMethod.GET)
    @RequestMapping(value="/list/{p}")
    public String IndexPage(@PathVariable Integer p,Model model) {
//    	List l = new ArrayList();
//    	for (int i=(p-1)*Page.RECORD_PER_PAGE; i<p*Page.RECORD_PER_PAGE; i++){
//    		Alarm a = new Alarm();
//    		a.setId(i+"");
//    		a.setTitle("tasfasdfasdf"+i);
//    		l.add(a);
//    	}
//    	
//    	Page page = new Page();
//    	page.setData(l);
    	
    	Pageable pp = new PageRequest(p,4);
    	List<AlarmObject> l = new ArrayList<AlarmObject>();
    	Page<AlarmObject> ppp = alarmInfoService.findBySome(pp);
    	
    	Iterator<AlarmObject> a = ppp.iterator();
    	while(a.hasNext()){
    		l.add(a.next());
    	}
    	
    	model.addAttribute("notices", ppp.iterator());
    	model.addAttribute("page", l);
        return "u/notice-list";
    }

    @RequestMapping(value="/test")
    public String test(){
    	for (int i=0; i<20; i++){
    		AlarmObject a = new AlarmObject();
    		a.setAlarmDate(new Date());
    		a.setAlarmType(2);
    		a.setContent("ASDFadfsadfasf"+i);
    		a.setTitle("adfafasfdasfasdf"+i);
    		a.setStatus(1);
    		a.setAuthor("test");
    		a.setAlarmTime(new Date());
    		alarmInfoService.save(a);
    	}
    	return "u/test";
    }

	
}
