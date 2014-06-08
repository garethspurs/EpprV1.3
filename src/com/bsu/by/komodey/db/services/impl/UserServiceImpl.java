package com.bsu.by.komodey.db.services.impl;

import com.bsu.by.komodey.RegexValidate;
import com.bsu.by.komodey.db.dao.UserDAO;
import com.bsu.by.komodey.db.dao.impl.UserDAOImpl;
import com.bsu.by.komodey.db.services.UserService;
import com.bsu.by.komodey.model.User;
import exceptions.SuspiciousDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO daoObj;

    public static ApplicationContext ctx;

    static{
        ctx = new ClassPathXmlApplicationContext("beans.xml");
    }
    public UserServiceImpl(){

    }

    @Override
    public boolean isInBase(String email, String password){
        return ((UserDAOImpl)daoObj).isExist(email, password);
    }

    @Override
    public Collection getValues(){
        return daoObj.getAll();
    }

    @Override
    public String getRole(String email){
        if(RegexValidate.emailValidate(email)){
            return daoObj.getUser(email).getRole();
        }
        return null;
    }

    @Transactional
    @Override
    public void delete(int id){
         daoObj.delete(id);
    }

    @Transactional
    @Override
    public void add(User user){
        try{
            if(RegexValidate.validateUser(user))
                daoObj.add(user);
            else throw new SuspiciousDataException();
        }
        catch (SuspiciousDataException e){
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id){
        return daoObj.getUser(id);
    }

    @Transactional
    @Override
    public void update( User user){
        try{
            if(RegexValidate.validateUser(user))
                daoObj.update(user);
            else{
                throw new SuspiciousDataException();
            }
        }
        catch (SuspiciousDataException e){
            e.printStackTrace();
        }
    }
}
