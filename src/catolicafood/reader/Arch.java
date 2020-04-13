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
import java.util.Locale;

/**
 *
 * @author andrey
 */
public class Arch {

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

    public boolean writeUserDoc(String email, String password) {
        boolean result = false;

        String emailF;
        String passwordF;

        try {
            FileWriter arq = new FileWriter(userDoc, true);
            FileReader arqR = new FileReader(userDoc);
            BufferedReader lerArq = new BufferedReader(arqR);

            emailF = email.toLowerCase();
            passwordF = password.toLowerCase();

            String linha = lerArq.readLine();
            while (linha != null) {
                linha = lerArq.readLine();

                if (linha.equals(emailF)) {
                    return result;
                }
            }
            arq.write(emailF + "\n" + passwordF + "\n");
            arq.close();
            result = true;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        return result;
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
    
    public void preencher() {
        String line;
        String[] var = new String[4];
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
