/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Loja;

//Packages
import catolicafood.utils.ListHist;
/**
 *
 * @author andrey
 */
public class Historico {
    
    private ListHist pedidos;
    private int tam;

    public int getTam() {
        return tam;
    }
    
    public ListHist getPedidos() {
        return pedidos;
    }

    public void setPedidos(ListHist pedidos) {
        this.pedidos = pedidos;
    }
}
