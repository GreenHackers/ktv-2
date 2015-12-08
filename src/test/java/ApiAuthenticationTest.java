/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.fontys.ktv.moc.domain.App;
import nl.fontys.ktv.moc.domain.RoundStatus;
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
public class ApiAuthenticationTest {

    final String name = "Api Authentication Test";
    private App app;

    /**
     * Test for authentication on the app
     */
    public ApiAuthenticationTest() {
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
     * Admin authentication test
     */
    @Test
    public void loginTest() {
        assertEquals(app.login("admin", "admin"), true);
    }
    
    /**
     * Guest authentication test
     */
    @Test
    public void loginAsGuest() {
        assertEquals(app.loginAsGuest(), true);
    }
    
    /**
     * Log off test
     */
    @Test
    public void logoutTest() {
        assertEquals(app.logout(), true);
    }
    
    
}
