package com.twu.biblioteca;

/**
 * Created by qnxu on 4/25/15.
 */
public class TerminateSystem {
    protected void terminateSystemOrNot(String input){
        if(input.equals("q"))
        {
            System.out.println("You've quit from Biblioteca Library System! Hope you have a good day!");
            System.exit(0);
        }
    }
}
