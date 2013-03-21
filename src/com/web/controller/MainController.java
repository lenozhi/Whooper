package com.web.controller;

import java.util.ArrayList;

import java.util.List;


import javax.annotation.Resource;


import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.web.domain.Person;
import com.web.service.PersonService;

@Controller
@RequestMapping("/main")
@Component
public class MainController {

    protected static Logger logger = Logger.getLogger("controller");
    @Resource(name = "personService")
    private PersonService personService;

    //@ModelAttribute("persons")
    public List<Person> getAllPersons() {
        logger.debug("Retrieving all persons and adding it to ModelAttribute");
        return personService.getAll();
    }

    public List<String> getAllCurrencies() {
        logger.debug("Retrieving all currencies and adding it to ModelAttribute");

        List<String> currencies = new ArrayList<String>();
        currencies.add("Dollar");
        currencies.add("Yen");
        currencies.add("Pound");
        currencies.add("Euro");
        currencies.add("Dinar");

        return currencies;
    }

    /**
     * 处理和检索一个包含Perosn 的JSP Page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getAllPage(Model model) {

        logger.debug("debug Received request to show all persons page");
        logger.info("info Received request to show all persons page");
        model.addAttribute("persons", this.getAllPersons());
        return "personspage";
    }

    /**
     * �?��修改页面
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable Integer id, Model model) {

        logger.debug("Received request to show edit page");

        model.addAttribute("personAttribute", personService.get(id));
        model.addAttribute("currencies", getAllCurrencies());
        return "editpage";
    }

    /**
     * 新建页面
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNew(Model model) {

        logger.debug("Received request to show new page");

        model.addAttribute("personAttribute", new Person());
        model.addAttribute("currencies", getAllCurrencies());

        return "editpage";
    }

    /**
     * 保存修改结果
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("personAttribute") Person person,
            @PathVariable Integer id, Model model) {
        logger.debug("Received request to update person");

        person.setId(id);

        personService.edit(person);

        model.addAttribute("persons", personService.getAll());

        return "personspage";
    }
}
