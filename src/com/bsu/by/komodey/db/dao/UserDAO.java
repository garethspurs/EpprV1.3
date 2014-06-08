package com.bsu.by.komodey.db.dao;

import com.bsu.by.komodey.model.User;

import java.util.Collection;

public interface UserDAO {
    public void update(User user);

    public void add(User user);

    public void delete(int id);

    public User getUser(int id) ;

    public User getUser(String email) ;
    
    public Collection getAll();
}
