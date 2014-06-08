package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RedirectController {
    private UserService userServiceImpl =
            (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");

    @RequestMapping(value = "redirect/edit", method = RequestMethod.GET)
    public String get(@RequestParam("id") String id, Model model)  {
        int idL = Integer.parseInt(id);
        model.addAttribute("user", userServiceImpl.getUserById(idL));
        return "list/edit";
    }

    @RequestMapping(value = "redirect/login", method = RequestMethod.POST)
    public String redirectLoginPage(){
        return "login/login";
    }

    @RequestMapping(value = "redirect/add", method = RequestMethod.POST)
    public String redirectAddPage(){
        return "list/add";
    }

    @RequestMapping(value = "redirect/list", method = RequestMethod.POST)
    public String redirectListPage(Model model){
        model.addAttribute("users_set", userServiceImpl.getValues());
        return "list/list";
    }
}
