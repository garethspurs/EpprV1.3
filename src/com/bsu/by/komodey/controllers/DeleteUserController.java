package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DeleteUserController {

    @RequestMapping(value = "Delete", method = RequestMethod.GET)
    public String delete(Model model,
                         @RequestParam("id") String id) {

        UserService us =
                (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");
        int idI = Integer.parseInt(id);
//        if(req.getRemoteUser().equals(us.getUserById(id).getEmail())){
//            System.out.println("Fail to delete yourself.");
//            return;
//        }
        us.delete(idI);
        model.addAttribute("users_set", us.getValues());
        return "list/list";
    }
}
