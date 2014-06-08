package com.bsu.by.komodey.db.services;

import com.bsu.by.komodey.model.User;

import java.util.Collection;

public interface UserService {
    public void add(User user);

    public void update(User user);

    public void delete(long id);

    public User getUserById(long id);

    public Collection getValues();

    public String getRole(String email);

    public boolean isInBase(String email, String password);
}
