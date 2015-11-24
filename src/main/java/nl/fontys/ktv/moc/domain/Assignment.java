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
public class Assignment {
    
    private static int id;
    private String artifact;
    private String name;
    private String participantDescription;
    private String spectatorDescription;
    private DifficultyLevel level;
    private ArrayList<Hint> hints;
    
    public Assignment(){
        this.id += 1;
        this.hints = new ArrayList<Hint>();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getArtificat(){
        return this.artifact;
    }
    
    public void setArtifact(String artifact){
        this.artifact = artifact;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getParticipantDescription() {
        return participantDescription;
    }

    public void setParticipantDescription(String participantDescription) {
        this.participantDescription = participantDescription;
    }

    public String getSpectatorDescription() {
        return spectatorDescription;
    }

    public void setSpectatorDescription(String spectatorDescription) {
        this.spectatorDescription = spectatorDescription;
    }
    
    public DifficultyLevel getLevel(){
        return this.level;
    }
    
    public ArrayList<Hint> getHints(){
        return this.hints;
    }
    
    public void addHint(Hint hint){
        hint.setAssigment(this);
        this.hints.add(hint);
    }
    
}
