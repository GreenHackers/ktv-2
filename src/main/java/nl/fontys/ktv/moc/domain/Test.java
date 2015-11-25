/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import nl.fontys.ktv.moc.stub.ApiStub;

/**
 *
 * @author Jeroen
 */
public class Test {
    public static void main(String[] args) {
        IWebservice api = new Api();
        //IWebservice api = new ApiStub();
        try {
            String jsonData = api.call("/users/666", IWebservice.httpRequestType.GET);
            
            System.out.println(jsonData);
        } catch(Exception e) {
            System.out.println(e);
        }
        
        
    }
}
