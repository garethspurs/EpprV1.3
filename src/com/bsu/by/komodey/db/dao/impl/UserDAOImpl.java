package com.bsu.by.komodey.db.dao.impl;

import com.bsu.by.komodey.db.UserMapper;
import com.bsu.by.komodey.db.dao.UserDAO;
import com.bsu.by.komodey.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Collection;

@Service
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {

    private static final String DELETE_ROW = "DELETE FROM users WHERE ID = ?;";
    private static final String UPDATE_ROW = "UPDATE users SET email=?, password=?, name=?, surname=?, role=? WHERE ID=?";
    private static final String UPDATE_ROW_PHONE = "UPDATE users_info SET phone = ? WHERE ID=?";
    private static final String ADD_ROW_USERS = "INSERT INTO users(email,password, name, surname,role) values (?,?,?,?,?);";
    private static final String ADD_ROW_PHONE = "INSERT INTO users_info(phone) value (?);";
    private static final String GET_ALL = "SELECT users.*, users_info.phone FROM users LEFT JOIN users_info ON users.ID = users_info.id;";
    private static final String GET_BY_ID = "SELECT users.*, users_info.phone FROM users LEFT JOIN users_info ON users.ID = users_info.id WHERE users.ID = ?";
    private static final String GET_BY_EMAIL = "SELECT users.*, users_info.phone FROM users left join  users_info on users.ID = users_info.id where email = ?;";
    private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT users.*, users_info.phone FROM users left join  users_info on users.ID = users_info.id where email = ? and password = ?;";

    @Autowired
    public UserDAOImpl(DataSource dataSource){
        setDataSource(dataSource);
    }

    @Override
    public void add(User user){
        getJdbcTemplate().update(ADD_ROW_USERS,
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getRole());
        getJdbcTemplate().update(ADD_ROW_PHONE,
                user.getPhone());
    }

    @Override
    public void update(User user){
        getJdbcTemplate().update(UPDATE_ROW,
                user.getEmail(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getRole(),
                user.getId());
        getJdbcTemplate().update(UPDATE_ROW_PHONE,
                user.getPhone(),
                user.getId());
    }

    @Override
    public void delete(int id) {
        getJdbcTemplate().update(DELETE_ROW, id);
    }

    public boolean isExist(String email, String password){
        User user = getJdbcTemplate().queryForObject(SELECT_BY_EMAIL_PASSWORD,
                new Object[]{email, password},
                new UserMapper());
        return user != null;
    }

    @Override
    public User getUser(String email){
        return getJdbcTemplate().
                queryForObject(GET_BY_EMAIL,
                new Object[]{email},
                new UserMapper());
    }
    @Override
    public User getUser(int id){
        return getJdbcTemplate().
                queryForObject(GET_BY_ID,
                new Object[]{id},
                new UserMapper());
    }

    @Override
    public Collection getAll(){
        return getJdbcTemplate().
                query(GET_ALL,
                        new UserMapper());
    }
}