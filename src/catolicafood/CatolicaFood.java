package catolicafood;

import Reader.Arch;

public class CatolicaFood {

    static Cliente c1 = new Cliente();
    static Arch arq = new Arch();

    public static void main(String[] args) {
        System.out.println(arq.createDoc());
        c1.createAccount("Andreymelo44@gmail.com", "784512Am31");
        System.out.println("Login: " + c1.onLogin("Andreymelo44@gmail.com", "784512Am31"));
//        System.out.println(c1.onDeleteAccount());
//        arq.readDoc();
    }

}
