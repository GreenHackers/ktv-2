/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import nl.fontys.ktv.moc.domain.Assignment;
import nl.fontys.ktv.moc.domain.Competition;
import nl.fontys.ktv.moc.domain.DifficultyLevel;
import nl.fontys.ktv.moc.domain.Hint;
import nl.fontys.ktv.moc.domain.Member;
import nl.fontys.ktv.moc.domain.Round;
import nl.fontys.ktv.moc.domain.Team;
import nl.fontys.ktv.moc.driver.Driver;
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
public class DriverTest1 {
    
    private Driver driver;
    
    public DriverTest1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        driver = new Driver();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createCompetitionTest(){
        Competition c = driver.createCompetition();
        c.setDescription("De eerste wedstrijd");
        driver.updateCompetition(c);
        assertTrue(driver.getCompetitions().get(0).getDescription().equals(c.getDescription()));
    }
    
}
