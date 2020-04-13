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
public class Pedidos {
    
    private Items[] produtos;
    private double totalValue;

    public Pedidos() {
        this.produtos = null;
        this.totalValue = 0;
    }
    
    public Items[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Items[] produtos) {
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
        double aux = 0;

        for (i = 0; i < this.produtos.length; i++) {
            aux = Double.parseDouble(produtos[i].getValue());
            
            this.totalValue += aux;
        }
    }
}
