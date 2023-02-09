package com.example.study_sprinboot_security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping({"/",""}) // 일반 관리자가 접속 가능
    public ModelAndView main(ModelAndView modelAndView) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // 여기서 principal은 userdetails다
        String username;
        if (principal instanceof UserDetails) {
            //로그인이 되어있을때 UserDetails 안되어있으면 
            username = ((UserDetails)principal).getUsername();
        } else {
            // 로그인이 되어있지 않을때 annoymousUser로 뜸
            username = principal.toString();
        }

        String viewName = "/WEB-INF/views/main.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
    @GetMapping({"/admin"}) //관리자
    public ModelAndView admin(ModelAndView modelAndView) {
        String viewName = "/WEB-INF/views/admin.jsp";
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
