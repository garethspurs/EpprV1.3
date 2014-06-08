package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
public class DeleteUserController extends HttpServlet {

    @RequestMapping(value = "Delete", method = RequestMethod.GET)
    public String delete(Model model,
                         @RequestParam("id") String id) {

        UserService us =
                (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");
        long idL = Long.parseLong(id);
//        if(req.getRemoteUser().equals(us.getUserById(id).getEmail())){
//            System.out.println("Fail to delete yourself.");
//            return;
//        }
        us.delete(idL);
        model.addAttribute("users_set", us.getValues());
        return "list/list";
    }
}
