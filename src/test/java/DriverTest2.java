/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import nl.fontys.ktv.moc.domain.Assignment;
import nl.fontys.ktv.moc.domain.Competition;
import nl.fontys.ktv.moc.domain.Member;
import nl.fontys.ktv.moc.domain.Round;
import nl.fontys.ktv.moc.domain.Score;
import nl.fontys.ktv.moc.domain.Team;
import nl.fontys.ktv.moc.driver.Driver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Johan
 */
public class DriverTest2 {
    
    private Driver driver;
    
    public DriverTest2() {
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
       loadData();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void competitionTest(){
        driver.getCompetitions();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    private void loadData(){
        Competition c1 = driver.createCompetition();
        c1.setDescription("De eerste wedstrijd");
        c1.setTitle("Wedstrijd1");
        driver.updateCompetition(c1);
        
        Competition c2 = driver.createCompetition();
        c2.setDescription("De tweede wedstrijd");
        c2.setTitle("Wedstrijd2");
        driver.updateCompetition(c2);

        Competition c3 = driver.createCompetition();
        c3.setDescription("De derde wedstrijd");
        c3.setTitle("Wedstrijd3");
        driver.updateCompetition(c3);
        
        Team t1 = driver.createTeam();
        t1.setName("Team1");
        
        Team t2 = driver.createTeam();
        t2.setName("Team2");
        
        Team t3 = driver.createTeam();
        t3.setName("Team3");

       c1.addTeam(t1);
       c1.addTeam(t2);
       c1.addTeam(t3);
       
       c2.addTeam(t2);
       
       c3.addTeam(t3);
       
       t1.addMember(new Member("Lid1", "Lid1@moc.local.nl", t1));
       t1.addMember(new Member("Lid2", "Lid2@moc.local.nl", t1));
       t2.addMember(new Member("Lid3", "Lid3@moc.local.nl", t2));
       
       Assignment a1 = driver.createAssignment();
       a1.setArtifact("TestArtifact");
       a1.setName("Assignment1");
       a1.setParticipantDescription("aaa");
       a1.setSpectatorDescription("AAA");
       driver.updateAssignment(a1);

       Assignment a2 = driver.createAssignment();
       a2.setArtifact("TestArtifact2");
       a2.setName("Assignment2");
       a2.setParticipantDescription("bbb");
       a2.setSpectatorDescription("BBB");
       driver.updateAssignment(a2);

       Assignment a3 = driver.createAssignment();
       a3.setArtifact("TestArtifact3");
       a3.setName("Assignment3");
       a3.setParticipantDescription("ccc");
       a3.setSpectatorDescription("CCC");
       driver.updateAssignment(a3);
       
       Round r1 = driver.createRound();
       r1.setCompetition(c1);
       r1.setDuration(200);
       r1.setMultiplier(2);
       r1.setAssignment(a1);
       driver.updateRound(r1);
       
       Round r2 = driver.createRound();
       r2.setCompetition(c1);
       r2.setDuration(250);
       r2.setMultiplier(3);
       r2.setAssignment(a2);
       driver.updateRound(r2);
       
       Round r3 = driver.createRound();
       r3.setCompetition(c1);
       r3.setDuration(200);
       r3.setMultiplier(1);
       r3.setAssignment(a3);
       driver.updateRound(r3);

       Round r4 = driver.createRound();
       r4.setCompetition(c2);
       r4.setDuration(10);
       r4.setMultiplier(1);
       r4.setAssignment(a1);
       driver.updateRound(r4);
       
       Round r5 = driver.createRound();
       r5.setCompetition(c3);
       r5.setDuration(200);
       r5.setMultiplier(3);
       r5.setAssignment(a2);
       driver.updateRound(r4);
       
       Score s1 = driver.createScore();
       s1.setScore(1200);
       s1.setRound(r1);
       s1.setTeam(t1);
       driver.updateScore(s1);
              
       Score s2 = driver.createScore();
       s2.setScore(1500);
       s2.setRound(r2);
       s2.setTeam(t1);
       driver.updateScore(s2);

       Score s3 = driver.createScore();
       s3.setScore(800);
       s3.setRound(r2);
       s3.setTeam(t1);
       driver.updateScore(s3);

       Score s4 = driver.createScore();
       s4.setScore(300);
       s4.setRound(r4);
       s4.setTeam(t2);
       driver.updateScore(s4);
    }
    
}
