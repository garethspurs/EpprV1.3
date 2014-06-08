package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersListController {
    @RequestMapping(value = "UsersList", method = RequestMethod.GET)
    public String get(Model model){
        UserService userService =
                (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");
        model.addAttribute("users_set", userService.getValues());
        return "list/list";
    }

}