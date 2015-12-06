/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.util.ArrayList;
import nl.fontys.ktv.moc.stub.ApiStub;

/**
 *
 * @author Jeroen
 */
public class Test {

    public static void main(String[] args) {

        App app = new App();
        //ArrayList<Assignment> assignments = webservice.getAssignments();
        //ArrayList<Competition> competitions = webservice.getCompetitions();
        //ArrayList<Score> scores = webservice.getScores();
        //ArrayList<Round> rounds = webservice.getRounds();
        //ArrayList<User> users = webservice.getUsers();
        //User user = webservice.getCurrentUser();
        //ArrayList<Team> teams = webservice.getTeams();
        User user = new User();
        user.setFullName("Jeroen van Gijzel");
        user.setEmail("jeroenvangijzel@gmail.com");
        user.setRole(UserRole.USER);
        user.setTeamName("Fontys");
        user.setUserName("jeroen");
        user.setPassword("geheim");

        user = app.createUser(user);
        

    }
}
