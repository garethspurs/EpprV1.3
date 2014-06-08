package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import com.bsu.by.komodey.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModifyUserController {
    private UserService userServiceImpl =
            (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");

    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public String edit(@RequestParam("email")String email,
                          @RequestParam("password")String password,
                          @RequestParam("name")String name,
                          @RequestParam("surname")String surname,
                          @RequestParam("phone")String phone,
                          @RequestParam(value = "check", required = false)String check,
                          @RequestParam("id")String id,
                          Model model) {
        confirm(email, password, name, surname, phone, check, id);
        model.addAttribute("users_set", userServiceImpl.getValues());
        return "list/list";
    }

    public void confirm(String email,
                        String password,
                        String name,
                        String surname,
                        String phone,
                        String check,
                        String id){
        int idL = Integer.parseInt(id);
        String role;
        if(check==null){
            role = "user";
        }
        else {
            role = "admin";
        }
        User user = new User(idL, email, password, name, surname, role, phone);
        userServiceImpl.update(user);
    }
}
