/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Jeroen
 */
public interface IApi {

    String apiEndPoint = "";
    String apiAdminUsername = "";
    String apiAdminPassword = "";

    public enum httpRequestType {

        GET, POST, PUT, DELETE
    }

    public String call(String method, IApi.httpRequestType httpRequestType);
}
