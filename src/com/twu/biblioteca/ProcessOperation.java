package com.twu.biblioteca;

import java.io.IOException;

/**
 * Created by qnxu on 4/25/15.
 */
public class ProcessOperation extends TerminateSystem{
    private UserInput userInput = new UserInput();

    private BookList bookList;
    private Menu menu = new Menu();
    private String currentState = "";

    ProcessOperation(BookList list){
        bookList = list;
    }

    public void operateMenu() throws IOException {
        try {
            menu.printMenu();
            String input = userInput.inputWithConsole();
            terminateSystemOrNot(input);
            char menuInput = input.charAt(0);
            if (input.equals(null) || "012e".indexOf(menuInput) < 0)
                throw new IOException("wrong input format!!!");
            switch (menuInput) {
                case '0': bookList.printBookList();
                    jumpToMenu();
                    break;
                case '1': operateBookList("checkout");
                    break;
                case '2': operateBookList("returnBook");
                    break;
                case 'e': jumpToMenu();
                    break;
            }
        } catch (IOException e){
            System.out.println(e);
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
                currentState = "BookList";
                bookList.printOperationMessage(operation);
                String input = exitOrTerminateAccordingInput();
                if (!input.equals("e") && !input.equals("q")) {
                    String operationResult = bookList.checkoutOrReturnBook(operation, input);
                    bookList.printBookList();
                    nextOperation(operation, operationResult);
                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }


    private void nextOperation(String operation, String operationResult) throws IOException {
        if(operationResult.equals("successful"))
            operateBookList(operation);
        else if(operationResult.equals("unsuccessful"))
            operateBookList(operation);
    }


    private String exitOrTerminateAccordingInput() throws IOException{
        String input = userInput.inputWithConsole();
        terminateSystemOrNot(input);
        exitOrNot(input);
        return input;
    }


}
