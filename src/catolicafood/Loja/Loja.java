/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Loja;

//Packages
import catolicafood.utils.ListItems;

/**
 *
 * @author andrey
 */
public class Loja {
    
    private ListItems items;
    private int tam;
    
    public Loja() {
        this.items = null;
        this.tam = 0;
    }

    public ListItems getItems() {
        return items;
    }

    public void setItems(ListItems data) {
        this.items = data;
        this.tam = data.tam();
    }

    public int getTam() {
        return tam;
    }  
    
}
