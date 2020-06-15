/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.PrintWriter;

import java.io.IOException;
import java.util.ArrayList;

import catolicafood.utils.ListItems;
import catolicafood.utils.NodeItems;
import catolicafood.Loja.Items;
import catolicafood.exceptions.UserAlreadyExists;

/**
 *
 * @author andrey
 */
public class Arch {

    static ListItems list = new ListItems();

    final File userDoc = new File("./src/catolicafood/reader/Users.txt");
    final File itemsDoc = new File("./src/catolicafood/reader/Items.txt");

    public boolean createDoc() {

        boolean result = false;

        try {
            if (!userDoc.exists()) {
                userDoc.createNewFile();
                result = true;
            }

            if (!itemsDoc.exists()) {
                itemsDoc.createNewFile();
                result = true;
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }

    public void writeUserDoc(String email, String password) throws UserAlreadyExists {
//        boolean result = false;

        String emailF;
        String passwordF;

        try {
            FileWriter arq = new FileWriter(userDoc, true);
            FileReader arqR = new FileReader(userDoc);
            BufferedReader lerArq = new BufferedReader(arqR);

            emailF = email.toLowerCase();
            passwordF = password.toLowerCase();

            String line = "";
            do {
                line = lerArq.readLine();

                if (line == null) {
                    break;
                }

                if (line.equals(emailF)) {
//                    result = true;
//                    return result;
                    throw new UserAlreadyExists("Usuário já existe ");
                }
            } while (line != null);
            arq.write(emailF + "\n" + passwordF + "\n");
            arq.close();
//            result = true;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (UserAlreadyExists e) {
            System.err.println("Error: " + e.getMessage());
        }

//        return result;
    }

    public void deleteUser(String email, String password) {
        int i;

        try {
            FileReader arq = new FileReader(userDoc);
            BufferedReader lerArq = new BufferedReader(arq);

            FileWriter arq2 = new FileWriter(userDoc);
            BufferedWriter lerArq2 = new BufferedWriter(arq2);

            String linha = lerArq.readLine();
            ArrayList<String> data = new ArrayList();

            while (linha != null) {
                if (!linha.equals(email) || !linha.equals(password)) {
                    data.add(linha);
                }
                linha = lerArq.readLine();
            }

            arq.close();
            lerArq.close();

            for (i = 0; i < data.size(); i++) {
                lerArq2.write(data.get(i));
                lerArq2.newLine();
            }

            arq.close();
            lerArq2.close();
        } catch (Exception e) {
        }
    }

    public boolean writeItemsDoc(int id, String name, String value, String description, int key) {
        boolean result = false;

        try {
            FileWriter arq = new FileWriter(itemsDoc, true);

            arq.write(id + "-" + name + "-" + value + "-" + description + "-" + key + "\n");
            arq.close();
            result = true;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return result;
    }

    public boolean readDoc() {
        boolean result = false;

        try {
            FileReader arq = new FileReader(userDoc);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.printf("%s\n", linha);

                linha = lerArq.readLine();
            }

            result = true;
            arq.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return result;
    }

    public int newId() {
        int result = 0;

        try {
            FileReader arq = new FileReader(itemsDoc);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();

            if (linha == null) {
                return result;
            }

            while (linha != null) {
                result++;
                linha = lerArq.readLine();
            }
            arq.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }

    public ListItems preencher() {
        String line = "";
        String[] var;

        try {
            FileReader arq = new FileReader(itemsDoc);
            BufferedReader lerArq = new BufferedReader(arq);

            do {
                line = lerArq.readLine();
                if (line == null) {
                    break;
                }

                var = line.split("-");
                Items auxItems = new Items.ItemsBuilder()
                        .id(Integer.parseInt(var[0]))
                        .name(var[1])
                        .value(var[2])
                        .description(var[3])
                        .key(Integer.parseInt(var[4]))
                        .build();
                NodeItems auxNode = new NodeItems(auxItems, null);

                list.addFim(auxNode);
            } while (line != null);
            arq.close();

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
//        System.out.println(list);
        return list;
    }

    public boolean checkLogin(String email, String password) {
        boolean result = false;

        String emailF;
        String passwordF;

        int count = 0;

        try {
            FileReader arq = new FileReader(userDoc);
            BufferedReader lerArq = new BufferedReader(arq);

            emailF = email.toLowerCase();
            passwordF = password.toLowerCase();

            String linha;
            do {
                linha = lerArq.readLine();

                if (linha.equals(emailF)) {

                    break;
                }
            } while (linha != null);

            if (linha.equals(emailF)) {
                count++;
            }

            linha = lerArq.readLine();

            if (linha.equals(passwordF)) {
                count++;
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return count == 2;
    }
}
