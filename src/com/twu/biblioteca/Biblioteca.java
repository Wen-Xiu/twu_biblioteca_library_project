package com.twu.biblioteca;

import java.io.IOException;

public class Biblioteca {


    public static void main(String[] args) throws IOException {
//        JFrame frame = new JFrame("hello");
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        welcomeMessage.printWelcomeMessage();
        BookList booklist = new BookList();
        booklist.printLocalBookList();
        Menu menu = new Menu();
        menu.printMenu();
    }

}
