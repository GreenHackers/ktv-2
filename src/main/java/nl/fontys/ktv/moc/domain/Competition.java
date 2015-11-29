/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.util.ArrayList;

/**
 *
 * @author Johan
 */
public class Competition {
    
    private static int id;
    private String description;
    private String title;
    private ArrayList<Team> teams;
    private ArrayList<Round> rounds;
    private CompetitionStatus status;
    private String apiId; // id used on remote side
    
    public Competition(){
        this.id += 1;
        this.teams = new ArrayList<Team>();
        this.rounds = new ArrayList<Round>();
    }
    
    public Competition(String title){
        this.id += 1;
        this.title = title;
        this.teams = new ArrayList<Team>();
        this.rounds = new ArrayList<Round>();
    }

    public Competition(String title, String description){
        this.id +=1;
        this.title = title;
        this.description = description;
        this.teams = new ArrayList<Team>();
        this.rounds = new ArrayList<Round>();
    }
    
    public int getId() {
       return id;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public ArrayList<Round> getRounds(){
        return this.rounds;
    }
    
    public CompetitionStatus getStatus(){
        return this.status;
    }
    
    public ArrayList<Team> getTeams(){
        return this.teams;
    }
    
    public void addTeam(Team team){
        this.teams.add(team);
    }
    
    public void addRound(Round round){
        round.setCompetition(this);
        this.rounds.add(round);
    }
    
    public void start(){
        if(this.status != CompetitionStatus.STARTED){
            this.status = CompetitionStatus.STARTED;
        }
    }
    
    public void stop(){
        if(this.status != CompetitionStatus.ENDED) {
            this.status = CompetitionStatus.ENDED;
        }
    }

    /**
     * @return the apiId
     */
    public String getApiId() {
        return apiId;
    }

    /**
     * @param apiId the apiId to set
     */
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
}
