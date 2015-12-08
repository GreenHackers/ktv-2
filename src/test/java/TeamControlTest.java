/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import nl.fontys.ktv.moc.domain.App;
import nl.fontys.ktv.moc.domain.Member;
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
public class TeamControlTest {
    
    final String name = "Team Control Test";
    private App app;
    private Team team;
    private Member memberOne;
    private Member memberTwo;
    
     /**
     * Test for team control
     */
    public TeamControlTest() {
    }
    
    /**
     * Initialize the variables 
     */
    @Before
    public void setUp() {
        System.out.println("Set up for " + name);
        
        app = new App(new ApiStub());
        
        team = new Team();
        team.setName("fontys.ktv");
        team.setEmail("fontys.ktv@local.nl");
        
        memberOne = new Member("Jeroen", "jeroen@local.nl", team);
        team.addMember(memberOne);
        memberTwo = new Member("Johan", "johan@local.nl", team);
        team.addMember(memberTwo);
        app.createTeam(team);
    }
    
    /**
     * Release resources
     */
    @After
    public void tearDown() {
        System.out.println("Tearing down " + name);
    }

    /**
     * Test if number of members equals two.
     */
    @Test
    public void numberOfMembersTest(){
        assertEquals(team.getMembers().size() , 2);
    }
    
    /**
     * Test if memberOne exists in the team
     */
    @Test 
    public void memberOneTest(){
        assertTrue(team.getMembers().contains(memberOne));
    }
    /**
     * Test if memberTwo is on the second position
     */
    @Test 
    public void memberTwoTest(){
        assertEquals(team.getMembers().get(1), memberTwo);
    }
    
    /**
     * Test if membetThrees doesn't exists in the team
     */
    @Test
    public void memberThreeTest(){
        Member member = new Member("Bas", "base@local.nl", new Team());
        assertFalse(team.getMembers().contains(member));
    }
    
    /**
     * Test if memberFour isn't on the first position
     */
    @Test
    public void memberFourTest(){
        Member member = new Member("Bea", "bea@local.nl", team);
        assertNotEquals (team.getMembers().get(0), member);
    }
  
}
