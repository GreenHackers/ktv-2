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

        //Competition competition = app.getCompetition(997);
        //Assignment assignment = app.getAssignment("TestArtifact2");
        //Round round = app.getRound("888");
        //System.out.println("round");
        //System.out.println(round);
        app.getCompetitions();
        app.deleteCompetition("998");

        /*        
         Round round = new Round();
         round.setCompetition(competition);
         round.setDuration(3333);
         round.setMultiplier(6666);
         round.setAssignment(assignment);

         round = app.createRound(round);
         System.out.println("round");
         System.out.println(round);
         */
    }
}
