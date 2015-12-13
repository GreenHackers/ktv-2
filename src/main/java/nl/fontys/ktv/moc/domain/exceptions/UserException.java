/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain.exceptions;

/**
 *
 * @author Jeroen van Gijzel <jeroenvangijzel@gmail.com>
 */
public class UserException extends Exception {

    public UserException() {
    }

    public UserException(String msg) {
        super(msg);
    }
}
