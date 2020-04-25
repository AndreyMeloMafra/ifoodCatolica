/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Users;
import catolicafood.exceptions.UserAlreadyExists;
/**
 *
 * @author andrey
 */
public abstract class User {
    
    private String name;
    private String email;
    private String password;

    //getters & setters
    abstract String getName();

    abstract void setName(String nome);

    abstract String getEmail();

    abstract void setEmail(String email); 
    
    abstract String getPassword();

    abstract void setPassword(String password);
    
    abstract boolean onLogin(String email, String password);
    
    abstract void onDeleteAccount();
    
    abstract void createAccount(String email, String password) throws UserAlreadyExists;
    
//    public boolean onLogin(String email, String password) {
//        if
//    }
//    
//    public boolean onLogout(){
//        
//    }
}
