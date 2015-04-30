package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by qnxu on 4/25/15.
 */
public class MainProcessor {
    private UserInput userInput = new UserInput();

    private BookListProcessor bookListProcessor;
    private MovieListProcessor movieListProcessor;
    private Menu menu = new Menu();
    private String currentState = "";

    MainProcessor(BookListProcessor bookProcessor, MovieListProcessor movieProcessor){
        bookListProcessor = bookProcessor;
        movieListProcessor = movieProcessor;
    }


    public void operateMenu() throws IOException {
        try {
            menu.printMenu();
            String input = userInput.inputWithConsole();
            terminateSystemOrNot(input);
            char menuInput = input.charAt(0);
            if (input.equals(null) || "012345e".indexOf(menuInput) < 0)
                throw new IOException("wrong input format!!!");
            switch (menuInput) {
                case '0': bookListProcessor.printBookList();
                    jumpToMenu();
                    break;
                case '1': operateBookList("checkout");
                    break;
                case '2': operateBookList("return to library");
                    break;
                case '3': movieListProcessor.printMovieList();
                    jumpToMenu();
                    break;
                case '4': operateMovieList("checkout");
                    break;
                case '5': operateMovieList("return to library");
                    break;
                case 'e': jumpToMenu();
                    break;
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
            operateMenu();
        }
    }

    public void terminateSystemOrNot(String input){
        if(input.equals("q"))
        {
            System.out.println("You've quit from Biblioteca Library System! Hope you have a good day!");
            System.exit(0);
        }
    }
    public void jumpToMenu() throws IOException {
        operateMenu();
    }

    public void exitOrNot(String input) throws IOException {
        if(input.equals("e")) {
            System.out.println("You've exited from " + currentState);
            operateMenu();
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
