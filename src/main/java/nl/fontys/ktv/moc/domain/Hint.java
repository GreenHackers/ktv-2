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
public class Hint {
    
    private static int id;
    private Assignment assignment;
    private String text;
    private int time;
    
    public Hint(){
        this.id += 1;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Assignment getAssignment(){
        return this.assignment;
    }
    
    public void setAssigment(Assignment assignment){
        this.assignment = assignment;
    }
    
    public String getText(){
        return this.text;
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public int getTime(){
        return this.time;
    }
    
    public void setTime(int time){
        this.time = time;
    }
            
}
