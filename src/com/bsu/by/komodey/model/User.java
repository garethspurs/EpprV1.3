package com.bsu.by.komodey.model;
public class User {
    private long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String role;
    private String phone;

    public User() {

    }

    public User(String email, String password, String name, String surname, String role, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.phone = phone;
    }

    public User(long id, String email, String password, String name, String surname, String role, String phone) {
        this(email, password, name, surname, role, phone);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
