package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import com.bsu.by.komodey.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddUserController {
    UserService us =
            (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");

    @RequestMapping(value = "addUser/{rest}", method = RequestMethod.POST)
      public String addUser(@PathVariable("rest") String rest,
                            @RequestParam("email")String email,
                            @RequestParam("password")String password,
                            @RequestParam("name")String name,
                            @RequestParam("surname")String surname,
                            @RequestParam("phone")String phone,
                            @RequestParam(value = "checkAdmin", required = false)String checkAdmin,
                            Model model){
        System.out.println("azaza");
        add(email, password, name, surname, phone, checkAdmin);
        if(rest.equals("registration")){
            return "login/login";

        }
        if(rest.equals("byAdmin")){
            model.addAttribute("users_set", us.getValues());
            return "list/list";

        }

        return null;
    }
    private void add(String email,
                     String password,
                     String name,
                     String surname,
                     String phone,
                     String checkAdmin){
        String role;
        role = (checkAdmin == null) ? "user" : "admin";
        User user = new User(email, password, name, surname, role, phone);
        us.add(user);
    }
}
