/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.fontys.ktv.moc.domain.App;
import nl.fontys.ktv.moc.domain.Competition;
import nl.fontys.ktv.moc.domain.CompetitionStatus;
import nl.fontys.ktv.moc.stub.ApiStub;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
  * @author Johan Verhoeven <jrh.verhoeven@student.fontys.nl>
 */
public class CompetitionControlTest {
    
    final String name = "Competition Control Test";
    private App app ;
    private Competition competition;
    
    /**
     * Test for competition control
     */
    public CompetitionControlTest() {
    }

    /**
     * Initialize the variables 
     */
    @Before
    public void setUp() {
        System.out.println("Set up for " + name);
        
        app = new App(new ApiStub());
        competition = new Competition();
        competition.setDescription("Competition");
        competition.setTitle("Competition's title");
        competition = app.createCompetition(competition);
    }
    
    /**
     * Release resources
     */
    @After
    public void tearDown() {
        System.out.println("Tearing down " + name);
    }
    
    /**
     * Start the competition and test if the competition is started.
     */
    @Test
    public void competitionStartTest(){
        competition.start();
        assertEquals(competition.getStatus(), CompetitionStatus.STARTED );
    }

    /**
     * Start the competition then stops the competition and test if the 
     * competition has ended.
     */
    @Test 
    public void competitionStopTest(){
        competition.start();
        competition.stop();
        assertEquals(competition.getStatus(), CompetitionStatus.ENDED );
    }

}
