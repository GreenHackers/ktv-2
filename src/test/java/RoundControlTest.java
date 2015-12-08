/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.fontys.ktv.moc.domain.App;
import nl.fontys.ktv.moc.domain.Assignment;
import nl.fontys.ktv.moc.domain.Competition;
import nl.fontys.ktv.moc.domain.Round;
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
public class RoundControlTest {

    final String name = "Round Control Test";
    private App app;
    private Round round;

    /**
     * Test for round control
     */
    public RoundControlTest() {
    }


    /**
     * Initialize the variables 
     */
    @Before
    public void setUp() {
        System.out.println("Set up for " + name);
        
        app = new App(new ApiStub());

        Competition competition = new Competition();
        competition.setDescription("Competition");
        competition.setTitle("Competition's title");
        competition = app.createCompetition(competition);

        Assignment assignment = new Assignment();
        assignment.setName("Eerste ronde");
        assignment.setParticipantDescription("Ronde1");
        assignment.setSpectatorDescription("Dit is de eerste ronde voor de deelnemers");
        assignment = app.createAssignment(assignment);

        round = new Round();
        round.setAssignment(assignment);
        round.setCompetition(competition);
        round.setDuration(3600);
        round.setMultiplier(3);
        round = app.createRound(round);

    }

    /**
     * Release resources
     */
    @After
    public void tearDown() {
        System.out.println("Tearing down " + name);
    }

    /** 
     * Start the round and test is the round is started
     */
    @Test
    public void startRoundTest() {
        round.start();
        assertEquals(round.getStatus(), RoundStatus.STARTED);
    }

    /**
     * Start the round and pause the round and then test if the round is paused.
     */
    @Test
    public void pauseRoundTest() {
        round.start();
        round.pause();
        assertEquals(round.getStatus(), RoundStatus.PAUSED);
    }

    /**
     * Start the round and freeze the round and then test if the round is 
     * freezed.
     */
    @Test
    public void freezeRoundTest() {
        round.start();
        round.freeze();
        assertEquals(round.getStatus(), RoundStatus.FROZEN);
    }
    
    /**
     * Start the round and freeze the round and then test if the round is ended.
     */
    @Test
    public void stopRoundTest() {
        round.start();
        round.stop();
        assertEquals(round.getStatus(), RoundStatus.ENDED);
    }

}
