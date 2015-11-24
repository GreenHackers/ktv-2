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
public class Score {
 
    private static int id;
    private int score;
    private Round round;
    private Team team;
    
    public Score()
    {
        this.id += 1;
    }
   
    public int getId(){
        return id;
    }
    
    public Round getRound() {
        return round;
    }

    public void setRound(Round round){
        this.round = round;
    }
    
    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team){
        this.team = team;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }
    
}
