/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.fontys.ktv.moc.domain.Competition;
import nl.fontys.ktv.moc.domain.App;
import nl.fontys.ktv.moc.domain.Team;
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
public class ShowCurrentCompetitionInfoTest {
    
    final String name = "Show Current Competition Info Test";
    private App app;
    private Competition competition;
    
    /**
     * Test for show current competition info
     */
    public ShowCurrentCompetitionInfoTest() {
    }

    
    /**
     * Initialize the variables 
     */
    @Before
    public void setUp() {
        System.out.println("Set up for " + name);
        
        app = new App(new ApiStub());
        competition = app.getCurrentCompetition();
    }
    
    /**
     * Release resources
     */
    @After
    public void tearDown() {
        System.out.println("Tearing down " + name);
    }
    
    /**
     * Test is the current competition is not null
     */
    @Test
    public void getCurrentCompetitionTest(){
        
        assertNotNull(competition);
    }
    
    /**
     * Test is the current competition has an id
     */
    @Test
    public void currentCompetitionIdTest(){
        assertNotEquals(competition.getApiId(), 0);
    }
    
    /**
     * Test is the current competition has an empty team list
     */
    @Test
    public void currentCompetitionTeamsTest(){
        Team[] expecteds = new Team[0];
        Team[] actuals = new Team[competition.getTeams().size()];
        assertArrayEquals(expecteds , actuals );
    }
    
    /**
     * Test is the current competition has rounds.
     */
    @Test
    public void currentCompetitionRoundsTest(){
        assertNotNull(competition.getRounds());
    }
    
    
}
