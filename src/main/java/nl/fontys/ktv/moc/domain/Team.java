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
}
