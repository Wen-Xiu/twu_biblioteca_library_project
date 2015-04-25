package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.*;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by qnxu on 4/20/15.
 */
public class BookListTest extends TestCase {

    @Test
    public void testCheckout() throws IOException {

        BookList mockBookList = mock(BookList.class);
        UserInput mockUserInput = mock(UserInput.class);

        Hashtable books = new Hashtable();
        Hashtable lentBooks = new Hashtable();
        String bookName = "<Jane Eyre>";
        books.put(bookName, "author, publish data");
        BookList bookListForTest = new BookList(books,lentBooks);

        assertEquals("successful",bookListForTest.checkoutOrReturnBook("checkout","<Jane Eyre>"));
        assertTrue(books.isEmpty());
        assertTrue(lentBooks.containsKey("<Jane Eyre>"));
        assertEquals("unsuccessful",bookListForTest.checkoutOrReturnBook("checkout","<unavailable book>"));
    }

}
