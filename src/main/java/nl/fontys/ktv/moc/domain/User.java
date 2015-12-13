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
public class User {
    
    private static int id;
    private String userName;
    private String email;
    private String fullName;
    private String password;
    private UserRole role;
    private String teamName;
    private String apiId; // id used on remote side

    public User (){
        this.id +=1;
    }

    public int getId(){
        return this.id;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
            
    public UserRole getRole() {
        return role;
    }
    
    public void setRole(UserRole role){
        this.role = role;
    }
    
    public String getTeamName() {
        return teamName;
    }
    
    public void setTeamName(String teamName){
        this.teamName= teamName;
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

    public String toString() {
        return "userName: " + userName;
    }

}
