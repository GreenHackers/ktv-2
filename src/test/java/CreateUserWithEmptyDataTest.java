/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.fontys.ktv.moc.domain.App;
import nl.fontys.ktv.moc.domain.User;
import nl.fontys.ktv.moc.stub.ApiStub;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jeroen van Gijzel <jeroenvangijzel@gmail.com>
 */
public class CreateUserWithEmptyDataTest {

    final String name = "Create User With Empty Data Test";
    private App app;

    /**
     * Test for user with empty data
     */
    public CreateUserWithEmptyDataTest() {
    }

     /**
     * Initialize the variables 
     */
    @Before
    public void setUp() {
        System.out.println("Set up for " + name);
        
        app = new App(new ApiStub());
    }

    /**
     * Release resources
     */
    @After
    public void tearDown() {
        System.out.println("Tearing down " + name);
    }

    /**
     * Create a new user with blank username en password. A exception is thrown.
     */
    @Test
    public void throwsExceptionTest() {

        try {
            User user = new User();
            user.setUserName("");
            user.setPassword("");
            user.setEmail("jeroenvangijzel@gmail.com");

            app.createUser(user);
            
            fail("Excpected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            
        }

    }
}
