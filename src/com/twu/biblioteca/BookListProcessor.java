package com.twu.biblioteca;
//import java.util.Scanner;
import java.io.IOException;
import java.util.*;

/**
 * Created by qnxu on 4/20/15.
 */
public class BookListProcessor extends ListProcessor {

    public static Hashtable availableBookList;
    public static Hashtable lentBookList;
    BookListProcessor(BookList list){
        availableBookList = list.availableBooks;
        lentBookList = list.lentBooks;
    }

    private void printListTitle(){
        System.out.println("       Name                Author    Year Published");
    }

    public void printBookList(){
        printListTitle();
        Enumeration keys = availableBookList.keys();
        while (keys.hasMoreElements()) {
            Book book = (Book)availableBookList.get(keys.nextElement());
            System.out.println(book.name + "    " + book.author + "    " + book.publishYear);
        }
    }

    public String checkoutOrReturnBook(String operation, String name)throws IOException {
       return checkoutOrReturn(operation, name, availableBookList, lentBookList);
    }

}
