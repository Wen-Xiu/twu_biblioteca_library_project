package com.twu.biblioteca;

/**
 * Created by qnxu on 4/30/15.
 */
public class User {

    private String userName, userPassword, userEmailAddress, userPhoneNumber;
    private boolean userState;

    User(String name, String password, String emailAddress, String phoneNumber){
        userName = name;
        userPassword = password;
        userEmailAddress = emailAddress;
        userPhoneNumber = phoneNumber;
        userState = false;
    }

    public boolean getUserState(){
        return userState;
    }

    public String getUserName(){
        return userName;
    }

    public String getUserEmailAddress(){
        return userEmailAddress;
    }

    public String getUserPhoneNumber(){
        return userPhoneNumber;
    }

    public boolean changeUserState(boolean state){
        userState = state;
        return userState;
    }

    public boolean verifyPassword(String password){
        if(userPassword.equals(password)) return true;
        else return false;
    }
}
