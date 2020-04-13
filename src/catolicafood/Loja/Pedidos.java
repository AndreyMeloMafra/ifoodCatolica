/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.Loja;


//Packages
import catolicafood.utils.ListItems;
import catolicafood.utils.NodeItems;
/**
 *
 * @author andrey
 */
public class Pedidos {
    
    private ListItems produtos;
    private double totalValue;
    private int tam;

    public Pedidos() {
        this.produtos = null;
        this.totalValue = 0;
        this.tam = 0;
    }
    
    public ListItems getProdutos() {
        return produtos;
    }

    public void setProdutos(ListItems produtos) {
        this.produtos = produtos;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
    
    private void calcTotalValue() {
        int i;
        double sumValue = 0;
        NodeItems aux = produtos.getInicio();
        
        while(aux != null) {
            sumValue += Double.parseDouble(aux.getValue().getValue());
            aux = aux.getProx();
        }

    }
}
