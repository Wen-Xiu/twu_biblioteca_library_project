package com.twu.biblioteca;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by qnxu on 4/30/15.
 */
public class UserProcessor {

    private List userList;
    private User loginUser;

    UserProcessor(Hashtable user){
        userList= new List(user);
        initializeUserList();
    }

    private void initializeUserList(){
        User user1 = new User("user1", "123", "user1@gmail.com","83615922");
        User user2 = new User("user2", "456", "user1@gmail.com","83615922");
        User user3 = new User("user3", "789", "user1@gmail.com","83615922");
        userList.addToList(user1);
        userList.addToList(user2);
        userList.addToList(user3);
    }

    private void printInfoTitle()
    {
        System.out.println("User Name           User Email Address            User Phone Number");
    }

    public void printUserInfo( ){
        printInfoTitle();
        System.out.println(loginUser.getUserName() + "    " + loginUser.getUserEmailAddress() + "    " + loginUser.getUserPhoneNumber());
    }

    public String loginSuccessfullyOrNot(String userName, String password){
        User user = getUserInfo(userName);
        if(user.verifyPassword(password) == true)
        {
            user.changeUserState(true);
            loginUser = getUserInfo(userName);
            return "successful";
        }
        else
        {
            user.changeUserState(false);
            return "unsuccessful";
        }
    }

    public User getUserInfo(String userName){
        return (User)userList.getObject(userName);
    }

    public void printLoginMessage(){
        System.out.println("please input username and password to login");
    }

//    private void



}
