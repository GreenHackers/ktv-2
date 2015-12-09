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
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date());

        User user = new User();
        user.setFullName("Jeroen van Gijzel - " + timeStamp);
        user.setEmail("jeroenvangijzel@gmail.com-" + timeStamp);
        user.setRole(UserRole.USER);
        user.setTeamName("Fontys-" + timeStamp);
        user.setUserName("jeroen-" + timeStamp);
        user.setPassword("geheim-" + timeStamp);

        user = app.createUser(user);
        

    }
}
