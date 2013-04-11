/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.whooper.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whooper.domain.AlarmObject;
import cn.whooper.domain.AlarmType;
import cn.whooper.domain.Page1;
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
   
    @RequestMapping(value="/list/{p}")
    public String IndexPage(@PathVariable Integer p,Model model) {
    	
    	Pageable pp = new PageRequest(p,Page1.RECORD_PER_PAGE);
    	String indexes = Page1.getPages(p);
    	List<AlarmObject> l = new ArrayList<AlarmObject>();
    	Page<AlarmObject> ppp = alarmInfoService.findBySome(pp);
    	
    	Iterator<AlarmObject> a = ppp.iterator();
    	while(a.hasNext()){
    		l.add(a.next());
    	}
    	
    	model.addAttribute("notices", ppp.iterator());
    	model.addAttribute("curpage", p);
    	model.addAttribute("types",typeList);
    	model.addAttribute("notice",new AlarmObject());
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

    
    static final List<AlarmType> typeList = new ArrayList<AlarmType>();
    static final SimpleDateFormat zeros = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    static final String zero = "01/01/1900 00:00:00";
   
    static {
    	
    	typeList.add(new AlarmType(1,"工作日"));
    	typeList.add(new AlarmType(2,"每天指定时间"));
    	typeList.add(new AlarmType(3,"指定时间单次"));
    }
    
	/**	 
     * 创建提醒
	 * @throws ParseException 
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody String add(
			 String content,
			 int type,
			 String time,
			 HttpServletRequest request
	) throws ParseException {
		AlarmObject ao = new AlarmObject();
		ao.setContent(content);
		ao.setAlarmType(type);
		ao.setCreatetime(new Date());
		ao.setStatus(1);
		Date date = null;
		if ( type == 3){
			 SimpleDateFormat sdfdate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			 date = sdfdate.parse(time);
			 ao.setAlarmDate(date);		
			 ao.setAlarmTime(zeros.parse(zero));
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			 date = sdf.parse(time);
			 ao.setAlarmTime(date);
			 ao.setAlarmDate(zeros.parse(zero));
		}
		ao.setAuthor("test");
		alarmInfoService.save(ao);
		return "ok";
	}
}
