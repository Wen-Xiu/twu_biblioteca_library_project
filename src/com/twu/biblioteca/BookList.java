package com.twu.biblioteca;
import java.io.*;
//import java.util.Scanner;
import java.util.Hashtable;
import java.util.*;

/**
 * Created by qnxu on 4/20/15.
 */
public class BookList extends TerminateSystem{


    private static Hashtable availableBooks;
    private static Hashtable lentBooks;

    private UserInput userInput = new UserInput();

    public BookList(Hashtable availableOnes, Hashtable unavailableOnes){
        availableBooks = availableOnes;
        lentBooks = unavailableOnes;
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

    public String checkoutOrReturnBook(String operation, String bookName)throws IOException{
        if(!operation.equals("returnBook") && !operation.equals("checkout"))
            throw new IOException("wrong input format!!!");
        else if(operation.equals("checkout"))
            return checkout(bookName);
        else
            return returnBook(bookName);

    }

    public String checkout(String bookName) throws IOException {
//        if(availableBooks.equals(null)) ;
        if (availableBooks.containsKey(bookName) == true)
            return successfulCheckout(bookName);
        else return unsuccessfulCheckout();

    }

    public String returnBook(String bookName) throws IOException {
        if (lentBooks.containsKey(bookName) == true)
            return  successfulReturnBook(bookName);
        else return unsuccessfulReturnBook();
    }

    public void printOperationMessage(String operation){
        System.out.println("Enter the book name to "+ operation + " the book");
    }

    private String successfulCheckout(String bookName){
        transferElementToAnotherHashTable(bookName, availableBooks, lentBooks);
        System.out.println("Thank you, enjoy the book!");
        return "successful";
    }
    private String unsuccessfulCheckout() throws IOException {
        System.out.println("That book is not available. Please enter again(press 'q' to quit)");
        return "unsuccessful";
    }

    private String successfulReturnBook(String bookName){
        transferElementToAnotherHashTable(bookName, lentBooks, availableBooks);
        System.out.println("Thank you for returning the book.");
        return "successful";
    }

    private String unsuccessfulReturnBook() throws IOException{
        System.out.println("Sorry, that is not a valid book to return.please enter again(press 'q' to quit)");
        return "unsuccessful";
    }

    public void transferElementToAnotherHashTable(String transferKey, Hashtable sourceTable, Hashtable DestTable){
        Object value = sourceTable.get(transferKey);
        DestTable.put(transferKey,value);
        sourceTable.remove(transferKey);
    }



}
