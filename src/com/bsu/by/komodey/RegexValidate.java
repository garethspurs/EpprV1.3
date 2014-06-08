package com.bsu.by.komodey;


import com.bsu.by.komodey.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexValidate {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    private static final String PASSWORD_PATTERN ="^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})$";
    private static final String NAME_PATTERN = "^[A-Za-z-]{2,20}$";
    private static final String PHONE_PATTERN = "^\\d{3}-\\d{7}$";

    public static boolean emailValidate(final String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        return validate(email);
    }

    public static boolean passwordValidate(final String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        return validate(password);
    }

    public static boolean nameValidate(final String name) {
        pattern = Pattern.compile(NAME_PATTERN);
        return validate(name);
    }

    public static boolean phoneValidate(final String phone) {
        pattern = Pattern.compile(PHONE_PATTERN);
        return validate(phone);
    }
    public static boolean validateUser(User user){
        if(emailValidate(user.getEmail()) &&
                passwordValidate(user.getPassword()) &&
                nameValidate(user.getName()) &&
                nameValidate(user.getSurname()) &&
                phoneValidate(user.getPhone())){
            return true;
        }
        return false;
    }

    private static boolean validate(String str){
        matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
