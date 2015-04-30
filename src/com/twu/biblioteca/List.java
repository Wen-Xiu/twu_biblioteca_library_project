package com.twu.biblioteca;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by qnxu on 4/25/15.
 */
public class List {
//    public static Hashtable availableBooks ;
//    public static Hashtable lentBooks;
    private Hashtable list;
//    private String listName;

    List(Hashtable listPassedIn){
        list = listPassedIn;
    }

    public void addToList(Book book){
        list.put(book.getBookName(),book);
    }

    public void removeFromList(Book book){
        list.remove(book.getBookName());
    }

    public void addToList(Movie movie){
        list.put(movie.getMovieName(),movie);
    }

    public void removeFromList(Movie movie){
        list.remove(movie.getMovieName());
    }

    public void addToList(User user)
    {
        list.put(user.getUserName(), user);
    }

    public void removeFromList(User user)
    {
        list.remove(user.getUserName());
    }


    public Hashtable getList(){
        return list;
    }

    public Enumeration getNamesFromList(){
        return list.keys();
    }

    public Object getObject(String name){
        return list.get(name);
    }

    public void addToList(String name,Object object){
        list.put(name,object);
    }

    public void removeFromList(String name){
        list.remove(name);
    }




}
