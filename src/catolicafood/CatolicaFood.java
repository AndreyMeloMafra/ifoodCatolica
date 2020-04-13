/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood;

import java.util.Scanner;

//Packages
import catolicafood.Users.Cliente;
import catolicafood.reader.Arch;
import catolicafood.menu.Menu;

/**
 *
 * @author andrey
 */
public class CatolicaFood {

//    static Cliente c1 = new Cliente();
    static Arch arq = new Arch();
    static Menu menu = new Menu();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        byte control;
        arq.createDoc();
        
        System.out.println("Bem vindo");
        System.out.println("Você deseja ir para: "
                + "\n1 - Login"
                + "\n2 - Criar conta");
        control = sc.nextByte();

        if (control == 1) {
            menu.loginMenu();
        } else if(control == 2) {
            menu.createAccountMenu();
        }

    }
}
