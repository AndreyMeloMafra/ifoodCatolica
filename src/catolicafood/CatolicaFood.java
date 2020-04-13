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
import catolicafood.Loja.Items;
import catolicafood.utils.ListItems;

/**
 *
 * @author andrey
 */
public class CatolicaFood {

//    static Cliente c1 = new Cliente();
    static Arch arq = new Arch();
    static Menu menu = new Menu();
    static Scanner sc = new Scanner(System.in);
    static Items i1 = new Items(1, "coca", "4.5", "Refrigerante em lata", 1);
    static Items i2 = new Items(2, "fanta", "4.", "Refrigerante em lata", 1);
    static Items i3 = new Items(3, "guarana", "4.75", "Refrigerante em lata", 1);
    static Items i4 = new Items(4, "sprite", "5", "Refrigerante em lata", 1);
    static ListItems list = new ListItems();

    public static void main(String[] args) {
        byte control;
        arq.createDoc();
        
        i1.createItem();
        i2.createItem();
        i3.createItem();
        i4.createItem();
        System.out.println("Bem vindo");
        System.out.println("Você deseja ir para: "
                + "\n1 - Login"
                + "\n2 - Criar conta");
        control = sc.nextByte();

        if (control == 1) {
            menu.loginMenu();
        } else if(control == 2) {
            menu.createAccountMenu();
        } else if(control == 0) {
            arq.preencher();
            System.out.println("lista: " + list);
//            System.out.println(i1.getName());
        }

    }
}
