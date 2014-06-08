package com.bsu.by.komodey.db;

import com.bsu.by.komodey.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException{
        int id = rs.getInt("ID");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String role = rs.getString("role");
        String phone = rs.getString("phone");
        return new User(id,email, password, name, surname, role, phone);
    }
}
