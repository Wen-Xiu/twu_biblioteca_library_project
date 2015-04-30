package com.twu.biblioteca;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by qnxu on 4/29/15.
 */
public class ListProcessor {
    private String listType;

    protected String checkoutOrReturn(String operation, String name, List availableList, List lentList)throws IOException {
        if(!operation.equals("return to library") && !operation.equals("checkout"))
            throw new IOException("wrong input format!!!");
        else if(operation.equals("checkout"))
            return checkout(name, availableList, lentList);
        else
            return returnToLibrary(name, availableList, lentList);
    }

    private String checkout(String name, List availableList, List lentList) throws IOException {
        if (availableList.getList().containsKey(name) == true)
            return successfulCheckout(name, availableList, lentList);
        else return unsuccessfulCheckout();

    }

    private String returnToLibrary(String name, List availableList, List lentList) throws IOException {
        if (lentList.getList().containsKey(name) == true)
            return  successfulReturn(name, availableList, lentList);
        else return unsuccessfulReturn();
    }

    public void printOperationMessage(String operation, String typeOfList){
        listType = typeOfList;
        System.out.println("Enter the " + listType + " name to " + operation);
    }

    private String successfulCheckout(String name, List availableList, List lentList){
        transferElementToAnotherHashTable(name, availableList, lentList);
        System.out.println("Thank you, enjoy the " + listType + "!");
        return "successful";
    }
    private String unsuccessfulCheckout() throws IOException {
        System.out.println("That " + listType + " is not available. Please enter again(press 'q' to quit)");
        return "unsuccessful";
    }

    private String successfulReturn(String name, List availableList, List lentList){
        transferElementToAnotherHashTable(name, lentList, availableList);
        System.out.println("Thank you for returning the " + listType + ".");
        return "successful";
    }

    private String unsuccessfulReturn() throws IOException{
        System.out.println("Sorry, that is not a valid " + listType + " to return. please enter again(press 'q' to quit system)");
        return "unsuccessful";
    }

    private void transferElementToAnotherHashTable(String name, List sourceList, List destList){
        Object value = sourceList.getList().get(name);
        destList.addToList(name, value);
        sourceList.removeFromList(name);
    }


}
