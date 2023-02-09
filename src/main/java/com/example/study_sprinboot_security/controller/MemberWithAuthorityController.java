package com.example.study_sprinboot_security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class MemberWithAuthorityController {
    @RequestMapping(value = "/joinMember", method=RequestMethod.GET)
    public ModelAndView joinForm(ModelAndView modelAndView) {
        String viewName= "/WEB-INF/views/joinForm.jsp";
        modelAndView.setViewName(viewName);
        return null;
    } 
    @RequestMapping(value = "/joinProc", method=RequestMethod.GET)
    public String joinProc(ModelAndView modelAndView) {
        return "redirect:/";
    } 
}
