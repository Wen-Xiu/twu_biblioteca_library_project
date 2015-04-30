package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by qnxu on 4/20/15.
 */
public class Menu{
    private Hashtable menu = new Hashtable();
    private UserInput userInput = new UserInput();

    private void initializeMenu(){
        menu.put(0, "List books");
        menu.put(1, "Checkout books");
        menu.put(2, "Return books");
        menu.put(3, "List movies");
        menu.put(4, "Checkout movies");
        menu.put(5, "Return movies");
    }

    public void printMenu() throws IOException {
        initializeMenu();
        printMenuTitle();
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + " : " + menu.get(i));
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
