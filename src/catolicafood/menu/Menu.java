/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.menu;

import java.util.Scanner;

//Packages
import catolicafood.Users.Cliente;
import catolicafood.Loja.Items;
import catolicafood.utils.NodeItems;
import catolicafood.reader.Arch;

/**
 *
 * @author andrey
 */
public class Menu {

    static Scanner sc = new Scanner(System.in);
    static Cliente c = new Cliente();
    static Arch arq = new Arch();

    public boolean loginMenu() {
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
        
        return logged;
    }

    public boolean createAccountMenu() {
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
        
        return created;
    }
    
    public void createItem() {
        int id = arq.newId();
        String name;
        String value;
        String description;
        int key = 1;
        
        System.out.print("Digite no nome do produto: ");
        name = sc.nextLine();
        
        System.out.print("Digite o valor do produto: ");
        value = sc.nextLine();
        
        System.out.print("Descreva o produto: ");
        description = sc.nextLine();
        
        Items item = new Items(id, name, value, description, key);
        item.createItem();
        
        NodeItems node = new NodeItems(item, null);
    }
    
    public void showItems() {
        
    }
}
