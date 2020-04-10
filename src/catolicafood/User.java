package catolicafood;

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
    
//    public boolean onLogin(String email, String password) {
//        if
//    }
//    
//    public boolean onLogout(){
//        
//    }
}
