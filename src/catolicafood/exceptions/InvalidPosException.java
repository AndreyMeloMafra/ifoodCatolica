/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.exceptions;

/**
 *
 * @author andrey
 */
public class InvalidPosException extends Exception {

    public InvalidPosException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidPosException(String errorMessage) {
        super(errorMessage);
    }
}