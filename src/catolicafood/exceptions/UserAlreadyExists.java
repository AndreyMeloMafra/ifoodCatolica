/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.exceptions;

import java.io.IOException;

/**
 *
 * @author andrey
 */
public class UserAlreadyExists extends IOException {
    
    public UserAlreadyExists(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
