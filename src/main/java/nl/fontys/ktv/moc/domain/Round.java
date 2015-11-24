/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

/**
 *
 * @author Johan
 */
public class Round {
    
    private static int id;
    private Competition competition;
    private Assignment assignment;
    private int duration;
    private int multiplier;
    private RoundStatus status;
            
    public Round(){
        this.id +=1;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public int getDuration(){
        return this.duration;
    }
    
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    public RoundStatus getStatus(){
        return this.status;
    }

    public int getMultiplier(){
        return this.multiplier;
    }
    
    public void setMultiplier(int multiplier){
        this.multiplier = multiplier;
               
    }
    
    public void start(){
        if(this.status != RoundStatus.STARTED) {
            this.status = RoundStatus.STARTED;
        }
    }
    
    public void stop(){
        if(this.status != RoundStatus.ENDED) {
            this.status = RoundStatus.ENDED;
        }
    }
    
    public void pause(){
        if(this.status == RoundStatus.STARTED) {
            this.status = RoundStatus.PAUSED;
        }
    }
    
    public void freeze(){
        if(this.status == RoundStatus.STARTED) {
            this.status = RoundStatus.FROZEN;
        }
    }
    
    public void addTime(int timeToAdd){
        this.duration += timeToAdd;
    }
}
