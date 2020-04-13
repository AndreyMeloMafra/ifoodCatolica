/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Loja;

/**
 *
 * @author andrey
 */
public class Historico {
    
    private Pedidos[] pedidos;
    private int tam;

    public int getTam() {
        return tam;
    }
    
    public Pedidos[] getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos[] pedidos) {
        this.pedidos = pedidos;
    }
}
