package com.bsu.by.komodey.controllers;

import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.db.services.impl.UserServiceImpl;
import com.bsu.by.komodey.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    UserService userServiceImpl =
            (UserService) UserServiceImpl.ctx.getBean("userServiceImpl");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);
        if(req.getParameter("action").equals("edit")){
            User user = userServiceImpl.getUserById(id);
            user.setPhone(req.getParameter("value"));
            userServiceImpl.update(user);
            resp.getWriter().print(req.getParameter("newPhone"));
        }
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
