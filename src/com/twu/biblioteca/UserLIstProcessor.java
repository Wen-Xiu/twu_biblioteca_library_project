package com.twu.biblioteca;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by qnxu on 4/30/15.
 */
public class UserListProcessor {

    private List userList;

    UserListProcessor(Hashtable user){
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
        System.out.println("       User Name           User Email Address            User Phone Number");
    }

    public void printUserInfo(){
        printInfoTitle();
        Enumeration keys = userList.getNamesFromList();
        while (keys.hasMoreElements()) {
            User user = (User)userList.getList().get(keys.nextElement());
            System.out.println(user.getUserName() + "    " + user.getUserEmailAddress() + "    " + user.getUserPhoneNumber());
        }
    }

    public String loginSuccessfullyOrNot(String userName, String password){
        User user = getUserInfo(userName);
        if(user.verifyPassword(password) == true)
        {
            user.changeUserState(true);
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

//    private void



}
