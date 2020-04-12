package Reader;

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

    final File file = new File("./src/Reader/Users.txt");

    public boolean createDoc() {

        boolean result = false;

        try {
            //para criar o arquivo
            if (!file.exists()) {
                file.createNewFile();
                result = true;
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return result;
    }

    public boolean writeDoc(String email, String password) {
        boolean result = false;

        String emailF;
        String passwordF;

        try {
            FileWriter arq = new FileWriter(file);

            emailF = email.toLowerCase();
            passwordF = password.toLowerCase();

            arq.write(emailF + "\n" + passwordF);
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
            FileReader arq = new FileReader(file);
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

    public boolean checkLogin(String email, String password) {
        boolean result = false;

        String emailF;
        String passwordF;
        
        int count = 0;
        
        try {
            FileReader arq = new FileReader(file);
            BufferedReader lerArq = new BufferedReader(arq);

            emailF = email.toLowerCase();
            passwordF = password.toLowerCase();
            
            String linha = lerArq.readLine();
            
            if(linha.equals(emailF)){
                count++;
            }
            
            linha = lerArq.readLine();
            
            if(linha.equals(passwordF)){
                count++;
            }
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        return count == 2;
    }
}
