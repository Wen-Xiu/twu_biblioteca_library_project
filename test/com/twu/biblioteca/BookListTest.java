package com.twu.biblioteca;

import junit.framework.TestCase;
import org.mockito.Mockito.*;

import java.util.Hashtable;

import static org.mockito.Mockito.mock;


/**
 * Created by qnxu on 4/20/15.
 */
public class BookListTest extends TestCase {

    public void testReturnBoo(){
        BookList mockBookList = mock(BookList.class);
        String bookName = "<test book>";
        Hashtable lentBook = new Hashtable();
        lentBook.put(bookName,"author, publish data");
    }
}
