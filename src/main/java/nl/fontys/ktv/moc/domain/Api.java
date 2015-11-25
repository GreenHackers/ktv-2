/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.StringEntity;

/**
 *
 * @author Jeroen van Gijzel
 */
public class Api implements IWebservice {

    private String apiEndPoint = "http://localhost:8083/api";
    private String apiAdminUsername = "admin";
    private String apiAdminPassword = "admin";

    // @TODO accept and process parameters
    public String call(String method, IWebservice.httpRequestType httpRequestType) throws UnsupportedEncodingException, IOException, Exception {

        // Create httpClient
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Authenticate as admin user
        HttpPost httpPost = new HttpPost(apiEndPoint + "/security");
        httpPost.setEntity(new StringEntity(apiAdminUsername + ";" + apiAdminPassword));
        HttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() != 204) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode() + ". Invalid username/password?");
        }

        HttpRequestBase httpCall = null;
        switch (httpRequestType) {
            case POST:
                httpCall = new HttpPost(apiEndPoint + method);
                break;
            case GET:
                httpCall = new HttpGet(apiEndPoint + method);
                break;
            case DELETE:
                httpCall = new HttpDelete(apiEndPoint + method);
                break;
            case PUT:
                httpCall = new HttpPut(apiEndPoint + method);
                break;
        }

        response = httpClient.execute(httpCall);

        //System.out.println(httpCall);
        // @TODO Use stub for returning dummy data whlle testing
        return "json data";
    }
}