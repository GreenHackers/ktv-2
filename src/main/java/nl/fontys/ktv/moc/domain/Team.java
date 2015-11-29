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
public class Team {
    
    private static int id;
    private String name;
    private String email;
    private int totalscore;
    private String apiId; // id used on remote side

    final ArrayList<Member> members;
    
    public Team(){
        this.id += 1;
        this.members = new ArrayList<Member>();
    }

    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public ArrayList<Member> getMembers(){
        return members;
    }
    
    public void addMember(Member member){
        this.members.add(member);
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

    /**
     * @return the totalscore
     */
    public int getTotalscore() {
        return totalscore;
    }

    /**
     * @param totalscore the totalscore to set
     */
    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
    }
}
