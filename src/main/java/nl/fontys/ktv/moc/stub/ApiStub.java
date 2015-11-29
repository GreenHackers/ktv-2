/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.stub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import nl.fontys.ktv.moc.domain.IApi;

/**
 *
 * @author Jeroen van Gijzel
 */
public class ApiStub implements IApi {

    @Override
    public String call(String method, httpRequestType httpRequestType) {
        try {
            // Filename for stub
            String stubFileName = method.toLowerCase() + "." + httpRequestType.toString().toLowerCase();
            stubFileName = stubFileName.substring(1); // Skip first slash
            stubFileName = stubFileName.replace("/", "-");// Replace slashes from method call

            File file = new File("src/main/resources/stubs/" + stubFileName + ".txt");
            byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
            return new String(encoded, Charset.defaultCharset());
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }

    }
}
