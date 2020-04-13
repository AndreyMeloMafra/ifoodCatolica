/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.menu;

import java.util.Scanner;

//Packages
import catolicafood.Users.Cliente;

/**
 *
 * @author andrey
 */
public class Menu {

    static Scanner sc = new Scanner(System.in);
    static Cliente c = new Cliente();

    public void loginMenu() {
        String email;
        String password;
        boolean logged;

        System.out.print("Digite seu email: ");
        email = sc.nextLine();

        System.out.print("Digite sua senha: ");
        password = sc.nextLine();

        logged = c.onLogin(email, password);

        if (!logged) {
            System.out.println("Usuário/senha inválidos");
        } else {
            System.out.println("Entrando...");
        }
    }

    public void createAccountMenu() {
        String email;
        String password;
        boolean created;

        System.out.print("Digite seu email: ");
        email = sc.nextLine();

        System.out.print("Digite sua senha: ");
        password = sc.nextLine();

        created = c.createAccount(email, password);
        
        if(!created) {
            System.out.println("Este usuário já existe!");
        } else {
            System.out.println("Criado com sucesso!");
        }
    }
}
