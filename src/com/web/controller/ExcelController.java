package com.web.controller;

import java.util.HashMap;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExcelController {

    protected static Logger logger = Logger.getLogger("controller");

    @RequestMapping("/")
    public String redirectMainPage() {
        return "registerpage";
    }

    @RequestMapping("/excel")
    public ModelAndView test(HttpServletRequest request,
            HttpServletResponse response) throws ServletRequestBindingException {

        String output =
                ServletRequestUtils.getStringParameter(request, "output");

        //dummy data
        Map<String, String> revenueData = new HashMap<String, String>();
        revenueData.put("Jan-2010", "$100,000,000");
        revenueData.put("Feb-2010", "$110,000,000");
        revenueData.put("Mar-2010", "$130,000,000");
        revenueData.put("Apr-2010", "$140,000,000");
        revenueData.put("May-2010", "$200,000,000");

        return new ModelAndView("excelRevenueSummary", "revenueData", revenueData);
    }
}
