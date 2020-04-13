/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.utils;

//Package
import catolicafood.Loja.Items;
/**
 *
 * @author andrey
 */
public class NodeItems {
    
    private Items value;
    private NodeItems prox;
    
    public NodeItems(){
        this.value = null;
        this.prox = null;
    }
    
    public NodeItems(Items value, NodeItems prox) {
        this.value = value;
        this.prox = prox;
    }

    public Items getValue() {
        return value;
    }

    public void setValue(Items value) {
        this.value = value;
    }

    public NodeItems getProx() {
        return prox;
    }

    public void setProx(NodeItems prox) {
        this.prox = prox;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }
}
