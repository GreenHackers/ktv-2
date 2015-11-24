/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import nl.fontys.ktv.moc.domain.Competition;
import nl.fontys.ktv.moc.domain.CompetitionStatus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Johan
 */
public class NewEmptyJUnitTest {
    
    private Competition competition;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.competition = new Competition("Master of Code");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void noStatusTest(){
        assertEquals(this.competition.getStatus(), null);
    }
 
    @Test
    public void startedTest(){
        competition.start();
        assertEquals(this.competition.getStatus(), CompetitionStatus.STARTED);
    }
}
