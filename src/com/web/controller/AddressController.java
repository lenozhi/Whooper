package com.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.domain.Address;
import com.web.service.AddressService;

@Controller
@RequestMapping("/address")
public class AddressController {

	protected static Logger logger = Logger.getLogger("controller");

	@Resource(name = "addressService")
	private AddressService addressService;

	/**
	 * 获得�?��Addresses,并使他们成为�?��model. 
	 * 注意@ModelAttribute作用于method级别上时.会在@Controller执行时加�?
	 * method里的方法.即在@Controller执行时@ModelAttribute添加参数.
	 * 返回于该@Controller返回的所有JSP页面.
	 */
	@ModelAttribute("addresses")
	public List<Address> getAllAddresses() {
		return addressService.getAll();
	}

	/**
	 * 处理和检索一个包含addresses 的JSP Page .
	 */
	@RequestMapping(value = "list1", method = RequestMethod.GET)
	public String getAllUsingModelAttribute() {
		logger.debug("Received request to show all addresses page");

		// 他会解析 /WEB-INF/jsp/addressespage.jsp
		return "addressespage";
	}

	/**
	 * 处理和检索一个包含addresses 的JSP Page .
	 * 
	 * @return the name of the JSP page
	 */
	@RequestMapping(value = "list2", method = RequestMethod.GET)
	public String getAllUsingModel(Model model) {
		logger.debug("Received request to show all addresses page");

		// �?���?��的address并装入model返回addressespage.jsp
		model.addAttribute("addresses", addressService.getAll());
		model.addAttribute("greetings", "I came from Model not ModelAttribute");

		// This will resolve to /WEB-INF/jsp/addressespage.jsp
		return "addressespage";
	}

}
