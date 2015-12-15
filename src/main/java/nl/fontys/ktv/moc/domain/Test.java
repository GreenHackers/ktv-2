/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.fontys.ktv.moc.domain.exceptions.UserException;
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
        user.setTeamName("aaaaaaa");
        user.setUserName("aaaaaaa");
        user.setPassword("geheim");

        try {
            user = app.createUser(user);
            System.out.println(user);
            System.out.println("User created.");
        } catch (UserException ex) {
            System.out.println("User NOT created.");
            System.out.println(ex);
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
