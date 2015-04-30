package com.twu.biblioteca;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.StringBufferInputStream;

/**
 * Created by qnxu on 4/30/15.
 */
public class UserListProcessorTest extends TestCase{


    public void testLoginSuccessfully(){
        Hashtable testUser = new Hashtable();
        UserListProcessor testUserList = new UserListProcessor(testUser);

        assertEquals("successful",testUserList.loginSuccessfullyOrNot("user1", "123"));
        assertEquals(true, testUserList.getUserInfo("user1").getUserState());
        assertEquals("unsuccessful",testUserList.loginSuccessfullyOrNot("user1","wrong password"));
        assertEquals(false, testUserList.getUserInfo("user1").getUserState());
    }
}
