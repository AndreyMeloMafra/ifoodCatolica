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
import catolicafood.utils.NodeItems;

/**
 *
 * @author andrey
 */
public class CatolicaFood {

    static Arch arq = new Arch();
    static Menu menu = new Menu();
    static Scanner sc = new Scanner(System.in);
    static ListItems list = new ListItems();
    static Cliente c = new Cliente();

    public static void main(String[] args) {
        byte control;
        byte itemsTotal;
        byte selectedId;
        boolean logged;
        boolean controlProgram = false;
        boolean controlMarket = false;
        char sell;
        char market;

        arq.createDoc();

        System.out.println("Bem vindo");
        while (!controlProgram) {
            System.out.println("Você deseja ir para: "
                    + "\n1 - Login"
                    + "\n2 - Criar conta");
            control = sc.nextByte();

            if (control == 1) {
                logged = menu.loginMenu();

                while (!controlMarket) {
                    if (logged) {
                        list = arq.preencher();
                        System.out.println("Items da loja");
                        System.out.println("Digite o id do item que você deseja comprar ou digite -1 para deletar sua conta: ");
                        System.out.println(list);
                        selectedId = sc.nextByte();

                        if (selectedId == -1) {
                            c.onDeleteAccount();

                            System.out.println("Obrigado por estar com nós, sentiremos sua falta :(");
                        }

                        NodeItems itemSelected = list.elementoEm(selectedId);
                        System.out.println("Você quer comprar " + itemSelected.getValue().getName() + " pelo valor de: R$" + itemSelected.getValue().getValue() + " (S/N)");
                        sell = sc.next().charAt(0);

                        if (sell == 's' || sell == 'S') {
                            System.out.println("Compra confirmada, o recibo estará em seu email, realize o pagamento na loja e retire seu pedido");
                        } else if (sell == 'n' || sell == 'N') {
                            System.out.println("Poxa :( volte para lista e procure algo que goste!");
                        }

                        System.out.print("Deseja continuar navegando pela loja? ");
                        market = sc.next().charAt(0);

                        if (market == 's' || market == 'S') {
                            System.out.println("Voltando...");
                        } else if (market == 'n' || market == 'N') {
                            System.out.println("Poxa :( volte mais tarde");
                            controlMarket = true;
                            controlProgram = true;
                        }
                        System.out.println("");
                    }
                }
                System.out.println("");
            } else if (control == 2) {
                menu.createAccountMenu();
                System.out.println("");
            } else if (control == 0) {
                System.out.println("Deseja inserir quantos items? ");
                itemsTotal = sc.nextByte();

                for (int i = 0; i < itemsTotal; i++) {
                    menu.createItem();
                }
                System.out.println("2");
            }
        }
    }
}
