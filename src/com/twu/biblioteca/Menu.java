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
        menu.put(0,"List books");
        menu.put(1,"Checkout books");
        menu.put(2,"Return books");
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

    public void printExit(){
        System.out.println("press 'q' to exit ");
    }

//    public void exitOrNot(String input) throws IOException {
//        if(input.equals("e")) {
//            System.out.println("You've exited from " + currentState);
//            printMenu();
//        }
//    }

//    public void menuOperate() throws IOException {
//        String menuInput = userInput.inputWithConsole();
//        terminateSystemOrNot(menuInput);
//        switch (menuInput.charAt(0)){
//            case '0': bookList.printBookList();
//                      jumpToMenu();
//                      break;
//            case '1': bookList.operateBookList("checkout");
//                      currentState = "BookList";
//                      break;
//            case '2': bookList.operateBookList("returnBook");
//                      currentState = "BookList";
//                      break;
//            case 'e': jumpToMenu();
//                      currentState = "BookList";
//                      break;
//        }
//    }
//
//    public void terminateSystemOrNot(String input){
//        if(input.equals("q"))
//        {
//            System.out.println("You've quit from Biblioteca Library System! Hope you have a good day!");
//            System.exit(0);
//        }
//    }


}
