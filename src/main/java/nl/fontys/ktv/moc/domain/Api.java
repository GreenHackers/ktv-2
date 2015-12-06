/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class Api implements IApi {

    private final String apiEndPoint = "http://localhost:8083/api";
    private final String apiAdminUsername = "admin";
    private final String apiAdminPassword = "admin";

    @Override
    public String call(String method, IApi.httpRequestType httpRequestType) {
        // Method is called without json input, call real method with an empty string.
        return call(method, httpRequestType, "");
    }

    // @TODO accept and process parameters
    public String call(String method, IApi.httpRequestType httpRequestType, String jsonInput) {

        try {
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

            // Create http request based on the given request type
            switch (httpRequestType) {
                case POST:
                    HttpPost httpPostCall = new HttpPost(apiEndPoint + method);

                    StringEntity inputPost = new StringEntity(jsonInput);
                    inputPost.setContentType("application/json");
                    httpPostCall.setEntity(inputPost);

                    // Execute call to the server
                    response = httpClient.execute(httpPostCall);

                    break;
                case GET:
                    HttpGet httpGetCall = new HttpGet(apiEndPoint + method);

                    // Execute call to the server
                    response = httpClient.execute(httpGetCall);
                    break;
                case DELETE:
                    HttpDelete httpDeleteCall = new HttpDelete(apiEndPoint + method);

                    // Execute call to the server
                    response = httpClient.execute(httpDeleteCall);
                    break;
                case PUT:
                    HttpPut httpPutCall = new HttpPut(apiEndPoint + method);

                    StringEntity inputPut = new StringEntity(jsonInput);
                    inputPut.setContentType("application/json");
                    httpPutCall.setEntity(inputPut);

                    // Execute call to the server
                    response = httpClient.execute(httpPutCall);
                    break;
            }

            // Check if statuscode equals 200 (OK)
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            // Read response and return
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            StringBuilder builder = new StringBuilder();
            String out = "";
            while ((out = reader.readLine()) != null) {
                builder.append(out);
            }

            // Filename for stub
            String stubFileName = method.toLowerCase() + "." + httpRequestType.toString().toLowerCase();
            stubFileName = stubFileName.substring(1); // Skip first slash
            stubFileName = stubFileName.replace("/", "-");// Replace slashes from method call

            // Write JSON data right into the stub file, for the lazy :-)
            PrintWriter pw = new PrintWriter("src/main/resources/stubs/" + stubFileName + ".txt");
            pw.write(builder.toString());
            pw.close();

            return builder.toString();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
