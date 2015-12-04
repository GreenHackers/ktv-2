/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.util.ArrayList;
import nl.fontys.ktv.moc.domain.*;
import nl.fontys.ktv.moc.stub.ApiStub;

/**
 *
 * @author Johan
 */
public class App {

    private ArrayList<Assignment> assignments;
    private ArrayList<Competition> competitions;
    private ArrayList<Hint> hints;
    private ArrayList<Round> rounds;
    private ArrayList<Score> scores;
    private ArrayList<User> users;
    private ArrayList<Team> teams;
    private final Webservice webservice;

    public App() {
        assignments = new ArrayList<>();
        competitions = new ArrayList<>();
        hints = new ArrayList<>();
        rounds = new ArrayList<>();
        scores = new ArrayList<>();
        users = new ArrayList<>();
        teams = new ArrayList<>();
        webservice = new Webservice();
        //webservice = new Webservice(new ApiStub());

    }

    /**
     * Returns a list with all asignments
     *
     * @return list with assignments
     */
    public ArrayList<Assignment> getAssignments() {
        assignments = webservice.getAssignments();
        return assignments;
    }

    /**
     * Creates as new assignments
     *
     * @return Assignment
     */
    public Assignment createAssignment(Assignment assignment) {
        assignment = webservice.createAssignment(assignment);
        if (assignment != null) {
            this.assignments.add(assignment);
        }

        return assignment;
    }

    /**
     * Updates a given assignment
     *
     * @param assignment assignment to update
     * @return boolean
     */
    public Assignment updateAssignment(Assignment assignment) {
        int index = -1;
        for (Assignment item : assignments) {
            if (item.getId() == assignment.getId()) {
                index = assignments.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            assignment = webservice.updateAssignment(assignment);
            if (assignment != null) {
                assignments.set(index, assignment);
                return assignment;
            }
        }

        return null;
    }

    /**
     * Finds a specic competition by it's id
     *
     * @param id of the competition to find
     * @return found competition
     */
    public Assignment getAssignment(int id) {
        return webservice.getAssignment(id);
    }

    /**
     * Deletes a given assignment
     *
     * @param id of the assignment to delete
     */
    public boolean deleteAssignment(int id) {

        for (Assignment item : assignments) {
            if (item.getId() == id) {
                if (webservice.deleteAssignment(id)) {
                    assignments.remove(item);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Returns a list with all competitions
     *
     * @return list with competitions
     */
    public ArrayList<Competition> getCompetitions() {
        competitions = webservice.getCompetitions();
        return competitions;
    }

    /**
     * Creates as new competitions
     */
    public Competition createCompetition(Competition competition) {
        competition = webservice.createCompetition(competition);
        if (competition != null) {
            this.competitions.add(competition);
        }

        return competition;
    }

    /**
     * Updates a giveb competition
     *
     * @param competition competition to update
     */
    public Competition updateCompetition(Competition competition) {
        int index = -1;
        for (Competition item : competitions) {
            if (item.getId() == competition.getId()) {
                index = competitions.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            competition = webservice.updateCompetition(competition);
            if (competition != null) {
                competitions.set(index, competition);
                return competition;
            }

            competitions.set(index, competition);
        }

        return null;
    }

    /**
     * Finds a specic competition by it's id
     *
     * @param id of the competition to find
     * @return found competition
     */
    public Competition getCompetition(int id) {
        return webservice.getCompetition(id);
    }

    /**
     * Deletes a given competitions
     *
     * @param id of the competition to delete
     */
    public boolean deleteCompetition(int id) {
        for (Competition item : competitions) {
            if (item.getId() == id) {
                if (webservice.deleteCompetition(id)) {
                    competitions.remove(item);
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * Gets the current competirtion. (If any, null ortherwise)
     *
     * @return
     */
    public Competition getCurrentCompetition() {
        return webservice.getCurrentCompetition();
    }

    /**
     * Starts a competition
     */
    public boolean startCompetition(Competition competition) {
        return webservice.startCompetition(competition);
    }

    /**
     * Stops the current competition. If a round is started within the current
     * competirtion, it will also be stopped.
     */
    public boolean stopCompetition() {
        return webservice.stopCompetition();
    }

    /**
     * Return a List with all hints
     *
     * @return List with hints
     */
    public ArrayList<Hint> getHints() {
        return webservice.getHints();
    }

    /**
     * Creates a new hint
     */
    public Hint createHint(Hint hint) {
        hint = webservice.createHint(hint);
        if (hint != null) {
            this.hints.add(hint);
        }
        return hint;
    }

    /**
     * Updates a given hint
     *
     * @param hint hint to update
     */
    public Hint updateHint(Hint hint) {
        int index = -1;
        for (Hint item : hints) {
            if (item.getId() == hint.getId()) {
                index = hints.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            hint = webservice.updateHint(hint);
            if (hint != null) {
                hints.set(index, hint);
                return hint;
            }
        }

        return null;
    }

    /**
     * Finds a specic hint by it's id
     *
     * @param id of the hint to find
     * @return found hint
     */
    public Hint getHint(int id) {
        return webservice.getHint(id);
    }

    /**
     * Deletes a given hint
     *
     * @param id of the hint to delete
     */
    public boolean deleteHint(int id) {
        for (Hint item : hints) {
            if (item.getId() == id) {
                if (webservice.deleteHint(id)) {
                    hints.remove(item);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Authenticates based on provided credentials. The credentials are passed
     * in the form of string containing the username and the password separated
     * by a semicolon (;).
     *
     * @param username username for the credentials
     * @param password password for the credentials
     */
    public boolean login(String username, String password) {
        return webservice.login(username, password);
    }

    /**
     * Logs in as a guest user. A guest user can see the spectator view.
     */
    public boolean loginAsGuest() {
        return webservice.loginAsGuest();
    }

    /**
     * Log out
     */
    public boolean logout() {
        return webservice.logout();
    }

    /**
     * Return a List with all rounds
     *
     * @return List with rounds
     */
    public ArrayList<Round> getRounds() {
        rounds = webservice.getRounds();
        return rounds;
    }

    /**
     * Creates a new round
     */
    public Round createRound(Round round) {
        round = webservice.createRound(round);
        if (round != null) {
            this.rounds.add(round);
        }
        return round;
    }

    /**
     * Updates a given round
     *
     * @param round round to update
     */
    public Round updateRound(Round round) {
        int index = -1;
        for (Round item : rounds) {
            if (item.getId() == round.getId()) {
                index = rounds.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            round = webservice.updateRound(round);
            if (round != null) {
                rounds.set(index, round);
                return round;
            }
        }
        return null;
    }

    /**
     * Finds a specic round by it's id
     *
     * @param id of the round to find
     * @return found round
     */
    public Round getRound(int id) {
        return webservice.getRound(id);
    }

    /**
     * Deletes a given round
     *
     * @param id of the round to delete
     */
    public boolean deleteRound(int id) {
        Round round = getRound(id);
        if (round != null) {
            if (webservice.deleteRound(id)) {
                rounds.remove(round);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns a list with all scores
     *
     * @return list with scores
     */
    public ArrayList<Score> getScores() {
        scores = webservice.getScores();
        return scores;
    }

    /**
     * Create a new score
     *
     * @return new score
     */
    public Score createScore(Score score) {
        score = webservice.createScore(score);
        if (score != null) {
            this.scores.add(score);
        }
        return score;
    }

    /**
     * Updates a given score
     *
     * @param score score to update
     */
    public Score updateScore(Score score) {
        int index = -1;
        for (Score item : scores) {
            if (item.getId() == score.getId()) {
                index = scores.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            score = webservice.updateScore(score);
            if (score != null) {
                scores.set(index, score);
                return score;
            }
        }

        return null;
    }

    /**
     * Return a List with all users
     *
     * @return List with users
     */
    public ArrayList<User> getUsers() {
        users = webservice.getUsers();
        return users;
    }

    /**
     * Creates a new user
     *
     * * @return new user
     */
    public User createUser(User user) {
        if (user.getUserName().trim() == "") {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        if (user.getPassword().trim() == "") {
            throw new IllegalArgumentException("Password cannot be empty.");
        }

        user = webservice.createUser(user);
        if (user != null) {
            this.users.add(user);
        }
        return user;
    }

    /**
     * Updates a given user
     *
     * @param user user to update
     */
    public User updateUser(User user) {
        int index = -1;
        for (User item : users) {
            if (item.getId() == user.getId()) {
                index = users.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            user = webservice.updateUser(user);
            if (user != null) {
                users.set(index, user);
                return user;
            }
        }
        return null;
    }

    /**
     * Finds a specic user by it's id
     *
     * @param id of the user to find
     * @return found user
     */
    public User getUser(int id) {
        return webservice.getUser(id);
    }

    /**
     * Deletes a given user
     *
     * @param id of the user to delete
     */
    public boolean deleteUser(int id) {
        User user = getUser(id);
        if (user != null) {
            if (webservice.deleteUser(id)) {
                users.remove(user);
                return true;
            }
        }

        return false;
    }

    /**
     * Get the currently authenticated user
     *
     * @return authenticated user
     */
    public User getCurrentUser() {
        return webservice.getCurrentUser();
    }

    /**
     * Return a List with all teams
     *
     * @return List with teams
     */
    public ArrayList<Team> getTeams() {
        teams = webservice.getTeams();
        return teams;
    }

    /**
     * Creates a new team
     */
    public Team createTeam(Team team) {
        team = webservice.createTeam(team);
        if (team != null) {
            this.teams.add(team);
        }
        return team;
    }

    /**
     * Updates a given team
     *
     * @param team team to update
     */
    public Team updateTeam(Team team) {
        int index = -1;
        for (Team item : teams) {
            if (item.getId() == team.getId()) {
                index = competitions.indexOf(item);
                break;
            }
        }
        if (index >= 0) {
            team = webservice.updateTeam(team);
            if (team != null) {
                teams.set(index, team);
                return team;
            }
        }

        return null;
    }

    /**
     * Finds a specic team by it's id
     *
     * @param id of the team to find
     * @return found team
     */
    public Team getTeam(int id) {
        return webservice.getTeam(id);
    }

    /**
     * Deletes a given team
     *
     * @param id of the team to delete
     */
    public boolean deleteTeam(int id) {
        Team team = getTeam(id);
        if (team != null) {
            if (webservice.deleteTeam(id)) {
                teams.remove(team);
                return true;
            }
        }

        return false;
    }

    /**
     * Get the currently authenticated team
     *
     * @return authenticated team
     */
    public Team getCurrentTeam() {
        return webservice.getCurrentTeam();
    }

}
