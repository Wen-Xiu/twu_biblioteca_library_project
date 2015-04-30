package com.twu.biblioteca;

import junit.framework.TestCase;

import java.util.Hashtable;

/**
 * Created by qnxu on 4/30/15.
 */
public class UserProcessorTest extends TestCase{


    public void testLoginSuccessfully(){
        Hashtable testUser = new Hashtable();
        UserProcessor testUserList = new UserProcessor(testUser);

        assertEquals("successful",testUserList.loginSuccessfullyOrNot("user1", "123"));
        assertEquals(true, testUserList.getUserInfo("user1").getUserState());
        assertEquals("unsuccessful", testUserList.loginSuccessfullyOrNot("user1", "wrong password"));
        assertEquals(false, testUserList.getUserInfo("user1").getUserState());
    }

}
