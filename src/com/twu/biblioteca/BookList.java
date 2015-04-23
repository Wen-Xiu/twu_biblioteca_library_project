package com.twu.biblioteca;
import java.io.*;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.*;

/**
 * Created by qnxu on 4/20/15.
 */
public class BookList {
//    private String[] books = {"<Jane Eyre>","<Lord of the Ring>","<Pride and Prejudice>","<the kiter runner>"};

    private static Hashtable availableBooks = new Hashtable();
    private static Hashtable lentBooks = new Hashtable();
    private String[][] ss = {{"0","<Jane Eyre>","author 1","1880-01-02"},{"1","<Lord of the Ring>","author 2","1880-03-09"}};
    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);
    public void printLocalBookList(){
        initiateBooks();
        printBookList();
    }

    public static void initiateBooks(){
        availableBooks.put("<Jane Eyre>", "author 1,   1880-01-02");
        availableBooks.put("<Lord of the Ring>", "author 2,   1880-03-09");
        availableBooks.put("<Pride and Prejudice>", "author 3,   1880-04-03");
        availableBooks.put("<the kiter runner>", "author 4,   1864-02-03");
    }

    private void printListTitle(){
        System.out.println("       Name                Author    Year Published");
    }

    public void printBookList(){
        printListTitle();
        Enumeration keys = availableBooks.keys();
        Enumeration elements = availableBooks.elements();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement() +"      "+elements.nextElement());
        }
    }

    public void operateBookList(String operation) throws IOException {
        if (operation.equals("checkout")) checkout();
        else if (operation.equals("returnBook")) {returnBook();}
    }

    private void checkout() throws IOException {
        System.out.println("Enter the book name to checkout the book");
        String input = sc.nextLine();
        Menu menu = new Menu();
        if(!input.equals("e")) {
            if (availableBooks.containsKey(input) == true) {
                successfulCheckout(input);
            }
            else unsuccessfulCheckout();
        }
        else {
            menu.currentState = "booklist";
            menu.exitOrNot(input);
            return;
        }
        printBookList();
        menu.jumpToMenu();
    }


    private void returnBook() throws IOException {
        System.out.println("Enter the book name to checkout the book");
        String input = sc.nextLine();
        Menu menu = new Menu();
        if(!input.equals("e")) {
            if (lentBooks.containsKey(input) == true)
            successfulReturnBook(input);
            else unsuccessfulReturnBook();
        }
        else {
            menu.currentState = "booklist";
            menu.exitOrNot(input);
            return;
        }
        printBookList();
        menu.jumpToMenu();
    }

    private void successfulCheckout(String bookName){
        transferElementToAnotherHashTable(bookName, availableBooks, lentBooks);
        System.out.println("Thank you, enjoy the book!");
    }
    private void unsuccessfulCheckout() throws IOException {
        System.out.println("That book is not available.");
        checkout();
    }

    private void successfulReturnBook(String bookName){
        transferElementToAnotherHashTable(bookName, lentBooks, availableBooks);
        System.out.println("Thank you for returning the book.");
    }

    private void unsuccessfulReturnBook() throws IOException{
        System.out.println("Sorry, that is not a valid book to return.");
        returnBook();
    }

    private void transferElementToAnotherHashTable(String transferKey, Hashtable sourceTable, Hashtable DestTable){
        Object value = sourceTable.get(transferKey);
        DestTable.put(transferKey,value);
        sourceTable.remove(transferKey);
    }

}
