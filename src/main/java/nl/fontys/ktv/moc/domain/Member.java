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
public class Member {
    
    private static int id;
    private String name;
    private String email;
    private Team team;
    
    public Member(String name, String email, Team team){
        this.id+=1;
        this.name = name;
        this.email = email;
        this.team = team;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public Team getTeam(){
        return this.team;
    }
    
    public void setTeam(Team team){
        this.team = team;
    }
}
