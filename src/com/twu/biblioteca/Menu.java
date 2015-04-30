package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by qnxu on 4/20/15.
 */
public class Menu{
    private Hashtable menuAfterLogin = new Hashtable();
    private Hashtable menuBeforeLogin = new Hashtable();
    private UserInput userInput = new UserInput();

    private void initializeMenuAfterLogin(){
        menuAfterLogin.put(0,"User Information");
        menuAfterLogin.put(1, "List books");
        menuAfterLogin.put(2, "Checkout books");
        menuAfterLogin.put(3, "Return books");
        menuAfterLogin.put(4, "List movies");
        menuAfterLogin.put(5, "Checkout movies");
        menuAfterLogin.put(6, "Return movies");
    }

    private void initializeMenuBeforeLogin(){
        menuBeforeLogin.put(0,"Login");
        menuBeforeLogin.put(1, "List books");
    }

    public void printMenuAfterLogin() throws IOException {
        initializeMenuAfterLogin();
        printMenuTitle();
        for (int i = 0; i < menuAfterLogin.size(); i++) {
            System.out.println(i + " : " + menuAfterLogin.get(i));
        }
    }

    public void printMenuBeforeLogin() throws IOException {
        initializeMenuBeforeLogin();
        printMenuTitle();
        for (int i = 0; i < menuBeforeLogin.size(); i++) {
            System.out.println(i + " : " + menuBeforeLogin.get(i));
        }
    }

    public void printMenuTitle(){
        System.out.println("MENU: ");
    }

    public void printExit()
    {
        System.out.println("press 'q' to exit ");
    }

}
