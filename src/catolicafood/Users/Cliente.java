/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Users;

import catolicafood.exceptions.UserAlreadyExists;
import catolicafood.reader.Arch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andrey
 */
public class Cliente extends User {

    static Arch arq = new Arch();

    private String email;
    private String name;
    private String password;
    private String cpf;
    private int age;
    private String course;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void createAccount(String email, String password) {
        try {
            arq.writeUserDoc(email, password);
        } catch (UserAlreadyExists ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean onLogin(String email, String password) {
        boolean logged = arq.checkLogin(email, password);
        if (logged) {
            return true;
        }

        return false;
    }

    public void onDeleteAccount() {
        arq.deleteUser(this.email, this.password);
    }

    public boolean changeData(int age) {
        if (age > 0) {
            this.age = age;
            return true;
        } else {
            return false;
        }
    }

    public boolean changeData(int pos, String data) {
        boolean result = true;
        switch (pos) {
            case 1:
                this.name = data;
                break;
            case 2:
                this.email = data;
                break;
            case 3:
                this.password = data;
                break;
            case 4:
                this.cpf = data;
                break;
            case 5:
                this.course = course;
                break;
            default:
                result = false;
                break;
        }

        return result;
    }
}
