package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by qnxu on 4/25/15.
 */
public class MainProcessor {
    private UserInput userInput = new UserInput();

    private BookListProcessor bookListProcessor;
    private MovieListProcessor movieListProcessor;
    private UserProcessor userProcessor;
    private Menu menu = new Menu();
    private String currentState = "";

    MainProcessor(BookListProcessor bookProcessor, MovieListProcessor movieProcessor, UserProcessor userProcessor){
        bookListProcessor = bookProcessor;
        movieListProcessor = movieProcessor;
        this.userProcessor = userProcessor;
    }

    public void operateMenuAfterLogin() throws IOException {
        try {
            menu.printMenuAfterLogin();
            String input = userInput.inputWithConsole();
            terminateSystemOrNot(input);
            char menuInput = input.charAt(0);
            if (input.equals(null) || "012345e".indexOf(menuInput) < 0)
                throw new IOException("wrong input format!!!");
            switch (menuInput) {
                case '0': userProcessor.printUserInfo();
                case '1': bookListProcessor.printBookList();
                    operateMenuAfterLogin();
                    break;
                case '2': operateBookList("checkout");
                    break;
                case '3': operateBookList("return to library");
                    break;
                case '4': movieListProcessor.printMovieList();
                    operateMenuAfterLogin();;
                    break;
                case '5': operateMovieList("checkout");
                    break;
                case '6': operateMovieList("return to library");
                    break;
                case 'e': operateMenuAfterLogin();;
                    break;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            operateMenuAfterLogin();
        }
    }


    public void operateMenuBeforeLogin(){
        try {
            menu.printMenuBeforeLogin();
            String input = userInput.inputWithConsole();
            terminateSystemOrNot(input);
            char menuInput = input.charAt(0);
            if (input.equals(null) || "012345e".indexOf(menuInput) < 0)
                throw new IOException("wrong input format!!!");
            switch (menuInput) {
                case '0': logIntoSystem();
                case '1': bookListProcessor.printBookList();
                    operateMenuBeforeLogin();
                    break;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            operateMenuBeforeLogin();
        }
    }


    public void logIntoSystem() throws IOException{
        String username = userInput.inputWithConsole();
        String password = userInput.inputWithConsole();
        if(userProcessor.loginSuccessfullyOrNot(username, password).equals("successful")){
            System.out.println("Welcome back!!");
            operateMenuAfterLogin();
        }
        else {
            System.out.println("Login failed, please check your username and passwords");
            operateMenuBeforeLogin();
        }
    }

    public void terminateSystemOrNot(String input){
        if(input.equals("q"))
        {
            System.out.println("You've quit from Biblioteca Library System! Hope you have a good day!");
            System.exit(0);
        }
    }

    public void exitOrNot(String input) throws IOException {
        if(input.equals("e")) {
            System.out.println("You've exited from " + currentState);
            operateMenuAfterLogin();
        }
    }

    public void operateBookList(String operation){
        while(true) {
            try {
                currentState = "book list";
                bookListProcessor.printOperationMessage(operation, "book");
                String input = exitOrTerminateOrReturnInput();
                if (!input.equals("e") && !input.equals("q")) {
                    String operationResult = bookListProcessor.checkoutOrReturnBook(operation, input);
                    bookListProcessor.printBookList();
                    nextOperation(operation, "book");
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void operateMovieList(String operation){
        while(true) {
            try {
                currentState = "movie list";
                movieListProcessor.printOperationMessage(operation, "movie");
                String input = exitOrTerminateOrReturnInput();
                if (!input.equals("e") && !input.equals("q")) {
                    String operationResult = movieListProcessor.checkoutOrReturnMovie(operation, input);
                    movieListProcessor.printMovieList();
                    nextOperation(operation, "movie");
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void nextOperation(String operation, String listType) throws IOException {
        if(listType.equals("book"))
            operateBookList(operation);
        else if(listType.equals("movie"))
            operateMovieList(operation);
    }


    private String exitOrTerminateOrReturnInput() throws IOException{
        String input = userInput.inputWithConsole();
        terminateSystemOrNot(input);
        exitOrNot(input);
        return input;
    }


}
