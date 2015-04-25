package com.twu.biblioteca;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by qnxu on 4/24/15.
 */
public class UserInput {

    private Scanner sc = new Scanner(System.in);
    public String inputWithConsole() throws IOException{

        String inputs = sc.nextLine();
        if(inputs.isEmpty())throw new IOException("you did nothing!");
        else return inputs;
    }
}
