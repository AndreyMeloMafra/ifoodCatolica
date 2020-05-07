package catolicafood.utils;


import catolicafood.Loja.Items;


public class NodeHist {
    
    private Items value;
    private NodeHist prox;

    public NodeHist(Items value) {
        this.value = value;
    }


    

    public Items getValue() {
        return value;
    }

    public void setValue(Items value) {
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
