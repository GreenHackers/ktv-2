/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.driver;

import java.util.ArrayList;
import nl.fontys.ktv.moc.domain.*;

/**
 *
 * @author Johan
 */
public class Driver {
    
    private ArrayList<Assignment> assignments;
    private ArrayList<Competition> competitions;
    private ArrayList<Hint> hints;
    private ArrayList<Round> rounds;
    private ArrayList<Score> scores;
    private ArrayList<User> users;
    private ArrayList<Team> teams;
    
    
    
    public Driver(){
        assignments = new ArrayList<>();
        competitions = new ArrayList<>();
        hints = new ArrayList<>();
        rounds = new ArrayList<>();
        scores = new ArrayList<>();
        users = new ArrayList<>();
        teams = new ArrayList<>();

    }
    
    /**
     * Returns a list with all asignments
     * @return list with assignments
     */
    public ArrayList<Assignment> getAssignments(){
        return this.assignments;
    }
    
    /**
     * Creates as new assignments
     */
    public Assignment createAssignment(){
        Assignment item = new Assignment();
        this.assignments.add(item);
        return item;
    }

    /**
     * Updates a given assignment
     * @param assignment assignment to update
     */
    public void updateAssignment(Assignment assignment){
        int index = -1;
        for(Assignment item : assignments){
            if(item.getId() == assignment.getId()){
                index = assignments.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            assignments.set(index, assignment);
        }
    }
    
    /** 
     * Finds a specic competition by it's id
     * @param id of the competition to find
     * @return found competition
     */
    public Assignment getAssignment(int id){
        for(Assignment item : assignments){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Deletes a given assignment
     * @param id of the assignment to delete
     */
    public void deleteAssignment(int id){
        Assignment item = getAssignment(id);
        if (item != null){
            assignments.remove(item);
        }
    }
    
    /**
     * Returns a list with all competitions
     * @return list with competitions
     */
    public ArrayList<Competition> getCompetitions(){
        return this.competitions;
    }
    
    /**
     * Creates as new competitions
     */
    public Competition createCompetition(){
        Competition item =  new Competition();
        this.competitions.add(item);
        return item;
    }
    
    /**
     * Updates a giveb competition
     * @param competition competition to update 
     */
    public void updateCompetition(Competition competition){
        int index = -1;
        for(Competition item : competitions){
            if(item.getId() == competition.getId()){
                index = competitions.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            competitions.set(index, competition);
        }
    }
    
    /** 
     * Finds a specic competition by it's id
     * @param id of the competition to find
     * @return found competition
     */
    public Competition getCompetition(int id){
        for(Competition item : competitions){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Deletes a given competitions
     * @param id of the competition to delete
     */
    public void deleteCompetition(int id){
        Competition item = getCompetition(id);
        if (item != null){
            competitions.remove(item);
        }
    }
    
    /**
     * Gets the current competirtion. (If any, null ortherwise)
     * @return 
     */
    public Competition getCurrentCompetition(){
        return null;
    }
            
    
    /**
     * Starts a competition
     */
    public void startCompetition(){
        
    }
    
    /**
     * Stops the current competition. If a round is started within the current
     * competirtion, it will also be stopped.
     */
    public void stopCompetition(){
        
    }
    
    /**
     * Return a List with all hints
     * @return List with hints
     */
    public ArrayList<Hint> getHints(){
        return this.hints;
    }
    
    /**
     * Creates a new hint
     */
    public Hint createHint(){
        Hint item = new Hint();
        this.hints.add(item);
        return item;
   }

    /**
     * Updates a given hint
     * @param hint hint to update
     */
    public void updateHint(Hint hint){
        int index = -1;
        for(Hint item : hints){
            if(item.getId() == hint.getId()){
                index = hints.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            hints.set(index, hint);
        }
    }
    
    /** 
     * Finds a specic hint by it's id
     * @param id of the hint to find
     * @return found hint
     */
    public Hint getHint(int id){
        for(Hint item : hints){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Deletes a given hint
     * @param id of the hint to delete
     */
    public void deleteHint(int id){
        Hint item = getHint(id);
        if (item != null){
            hints.remove(item);
        }
    }

    /**
     * Authenticates based on provided credentials. The credentials are passed
     * in the form of string containing the username and the password separated 
     * by a semicolon (;).
     * @param username username for the credentials
     * @param password password for the credentials
     */
    public void login(String username, String password){
        
    }
    
    /**
     * Logs in as a guest user. A guest user can see the spectator view.
     */
    public void loginAsGuest(){
        
    }
    
    /**
     * Return a List with all rounds
     * @return List with rounds
     */
    public ArrayList<Round> getRounds(){
        return this.rounds;
    }
    
    /**
     * Creates a new round
     */
    public Round createRound(){
        Round item = new Round();
        this.rounds.add(item);
        return item;
    }

    /**
     * Updates a given round
     * @param round round to update
     */
    public void updateRound(Round round){
        int index = -1;
        for(Round item : rounds){
            if(item.getId() == round.getId()){
                index = rounds.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            rounds.set(index, round);
        }
    }
    
    /** 
     * Finds a specic round by it's id
     * @param id of the round to find
     * @return found round
     */
    public Round getRound(int id){
        for(Round item : rounds){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Deletes a given round
     * @param id of the round to delete
     */
    public void deleteRound(int id){
        Round item = getRound(id);
        if (item != null){
            rounds.remove(item);
        }
    }

    
    /**
     * Returns a list with all scores
     * @return list with scores
     */        
    public ArrayList<Score> getScores(){
        return this.scores;
    }

    /**
     * Create a new score
     * @return new score
     */
    public Score createScore(){
        Score item = new Score();
        this.scores.add(item);
        return item;
    }

    /**
     * Updates a given score
     * @param score score to update
     */
    public void updateScore(Score score){
        int index = -1;
        for(Score item : scores){
            if(item.getId() == score.getId()){
                index = scores.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            scores.set(index, score);
        }
    }
    
    /**
     * Return a List with all users
     * @return List with users
     */
    public ArrayList<User> getUsers(){
        return this.users;
    }
    
    /**
     * Creates a new user
     * * @return new user
     */
    public User createUser(){
        User item = new User();
        this.users.add(item);
        return item;
    }
    
    /**
     * Updates a given user
     * @param user user to update
     */
    public void updateUser(User user){
        int index = -1;
        for(User item : users){
            if(item.getId() == user.getId()){
                index = users.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            users.set(index, user);
        }
    }
    
    /** 
     * Finds a specic user by it's id
     * @param id of the user to find
     * @return found user
     */
    public User getUser(int id){
        for(User item : users){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Deletes a given user
     * @param id of the user to delete
     */
    public void deleteUser(int id){
        User item = getUser(id);
        if (item != null){
            users.remove(item);
        }
    }
    
    /**
     * Get the currently authenticated user
     * @return authenticated user
     */
    public User getCurrentUser(){
        return null;
    }

    /**
     * Return a List with all teams
     * @return List with teams
     */
    public ArrayList<Team> getTeams(){
        return this.teams;
    }

        /**
     * Creates a new team
     */
    public Team createTeam(){
        Team t =  new Team();
        this.teams.add(t);
        return t;
    }
    
    /**
     * Updates a given team
     * @param team team to update
     */
    public void updateTeam(Team team){
        int index = -1;
        for(Team item : teams){
            if(item.getId() == team.getId()){
                index = competitions.indexOf(item);
                break;
            }
        }
        if (index >= 0 ){
            teams.set(index, team);
        }
    }
    
    /** 
     * Finds a specic team by it's id
     * @param id of the team to find
     * @return found team
     */
    public Team getTeam(int id){
        for(Team item : teams){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Deletes a given team
     * @param id of the team to delete
     */
    public void deleteTeam(int id){
        Team item = getTeam(id);
        if (item != null){
            teams.remove(item);
        }
    }
    
    /**
     * Get the currently authenticated team
     * @return authenticated team
     */
    public Team getCurrentTeam(){
        return null;
    }

}
