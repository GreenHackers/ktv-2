/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import nl.fontys.ktv.moc.domain.Assignment;
import nl.fontys.ktv.moc.domain.Hint;
import nl.fontys.ktv.moc.domain.Round;
import nl.fontys.ktv.moc.domain.Team;
import nl.fontys.ktv.moc.domain.App;
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
public class NewRoundTest {

    final String name = "New Round Test";
    private App app;
    private Round round;
    private Assignment assignment;
    private Hint hint;
    
    /**
     * Test for new round
     */
    public NewRoundTest() {
    }
      
    /**
     * Initialize the variables 
     */
    @Before
    public void setUp() {
        System.out.println("Set up for " + name);
        
        app = new App(new ApiStub());
        round = app.createRound(new Round());
        round.setDuration(120);
        
        assignment = app.createAssignment(new Assignment());
        assignment.setName("Eerste ronde");
        assignment.setParticipantDescription("Ronde1");
        assignment.setSpectatorDescription("Dit is de eerste ronde voor de deelnemers");
        round.setAssignment(assignment);
        assignment = app.updateAssignment(assignment);
        
        hint = app.createHint(new Hint());
        hint.setText("Kijk altijd verder dan je neus lang is!");
        hint.setTime(90);
        assignment.addHint(hint);
        hint = app.updateHint(hint);
        
        round = app.updateRound(round);
        
    }
    
    /**
     * Release resources
     */
    @After
    public void tearDown() {
        System.out.println("Tearing down " + name);
    }
    
    /**
     * Test if the created is added to the service
     */
    @Test
    public void roundCreatedTest(){
        Round r = app.getRound(this.round.getId());
        assertNotNull(r);
    }
   
    /**
     * Test if the hint in the round is correct
     */
    @Test
    public void giveHintTest(){
        assertSame(hint.getText(), "Kijk altijd verder dan je neus lang is!");
    }
}
