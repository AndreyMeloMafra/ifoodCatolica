/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.utils;

//Package
import catolicafood.Loja.Pedidos;
/**
 *
 * @author andrey
 */
public class NodeHist {
    
    private Pedidos value;
    private NodeHist prox;

    public Pedidos getValue() {
        return value;
    }

    public void setValue(Pedidos value) {
        this.value = value;
    }

    public NodeHist getProx() {
        return prox;
    }

    public void setProx(NodeHist prox) {
        this.prox = prox;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}
