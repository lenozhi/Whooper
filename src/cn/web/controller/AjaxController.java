package cn.web.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.web.domain.Person;

@Controller
@RequestMapping("/ajax")
@Component
public class AjaxController {

	@RequestMapping(value="/body",method=RequestMethod.GET)
	@ResponseBody
	public String h(HttpSession session){
		System.out.println(session);
		return "df";
	}

	@RequestMapping("/json1")   
    @ResponseBody      
    public void addUser(HttpEntity<Person> model) {      
      System.out.println("user: " + model.getBody());   
  
  }   
	
	/**
	 * ajax检测用户名
	 * @param enName
	 * @return
	 */
	@RequestMapping(value="/checkLoginName", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkLoginName( @RequestParam("enName") String enName){
		
		System.out.println("name:"+enName);
		if ( enName.equals("true"))
			return true;
		else 
			return false;
	}

	/**	 
     * 提交表单并进行运算
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody Integer add(
			Integer inputNumber1,
			 Integer inputNumber2,
			 String cnName,
			 HttpServletRequest request
			 ) {
		// 实现运算
		
		request(request);
		System.out.println(cnName);
		Integer sum = inputNumber1 + inputNumber2;
		System.out.println("sum: " + sum);
		// @ResponseBody 会自动的将返回�?转换成JSON格式
		// 但是你必须添加jackson的jar�?!!
		return sum;
	}
	
	@RequestMapping(value = "/get/{Id}", method = RequestMethod.POST)
	public @ResponseBody Person getUser(@PathVariable("Id")String  id,HttpServletRequest request) {
		request(request);
		System.out.println("根据ID获取用户对象: " + id);		
		Map<String,Person> users = new HashMap<String,Person>();
		users.put("1", new Person( 23,"我们"));
		users.put("2", new Person( 53,"sdfa"));
		users.put("3", new Person( 93,"wrerw"));
		users.put("4", new Person(13,"34343"));
		Person a = new Person( 43,"jhjh");
		a.setFriend(new Person(13,"34343"));
		users.put("5", a);		
		return users.get(id);
	}

	private void request(HttpServletRequest request){
		System.out.println(request.getCharacterEncoding());
		System.out.println(request.getContentType());
		System.out.println(request.getProtocol());
	
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()){
			Object o = e.nextElement();
			System.out.println(o+":"+request.getHeader((String)o));
		}
	}
}
