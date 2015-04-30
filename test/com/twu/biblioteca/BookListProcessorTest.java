package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Hashtable;

import static org.mockito.Mockito.mock;


/**
 * Created by qnxu on 4/20/15.
 */
public class BookListProcessorTest extends TestCase {
    @Before
    public void setUp(){
    }
    @Test
    public void testCheckoutOrReturnBook() throws IOException {
        Hashtable availableList = new Hashtable();
        Hashtable lentList = new Hashtable();

        BookListProcessor bookListProcessorForTest = new BookListProcessor(availableList, lentList);
        bookListProcessorForTest.printOperationMessage("return", "book");
        assertEquals("unsuccessful", bookListProcessorForTest.checkoutOrReturnBook("return to library", "Jane Eyre"));
        assertEquals("successful", bookListProcessorForTest.checkoutOrReturnBook("checkout", "Jane Eyre"));
        assertFalse(availableList.containsKey("Jane Eyre"));
        assertTrue(lentList.containsKey("Jane Eyre"));
        assertEquals("unsuccessful", bookListProcessorForTest.checkoutOrReturnBook("checkout", "unavailable book"));
        assertEquals("successful", bookListProcessorForTest.checkoutOrReturnBook("return to library", "Jane Eyre"));
        assertFalse(lentList.containsKey("Jane Eyre"));
        assertTrue(availableList.containsKey("Jane Eyre"));
    }

}
