/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catolicafood.utils;

/**
 *
 * @author andrey
 */
public class ListHist {

    private NodeHist inicio;
    private NodeHist fim;
    private int tam;

    public ListHist() {
        this.inicio = null;
        this.fim = null;
        tam = 0;
    }

    public NodeHist getInicio() {
        return inicio;
    }

    public NodeHist getFim() {
        return fim;
    }
    
    //Add functions
    public void addInicio(NodeHist data) {
        this.inicio = data;

        if (this.tam == 0) {
            this.fim = this.inicio;
        }
       
        tam++;
    }

    public void addFim(NodeHist data) {
        if (this.tam == 0) {
            addInicio(data);
        } else {
            this.fim.setProx(data);
            this.fim = data;
        }
        tam++;
    }

    public void addPos(NodeHist data, int pos) {
        if (pos == 0) {
            data.setProx(this.inicio.getProx());
            inicio = data;
        } else {
            NodeHist aux = elementoEm(pos - 1);
            aux.setProx(data);
        }
        tam++;
    }
    
    //Remove function
    public void remover(NodeHist data){
        int pos = search(data);
        NodeHist anterior = elementoEm(pos - 1);
        NodeHist proximo = elementoEm(pos + 1);
        anterior.setProx(proximo);
    }
    
    //Search function
    public int search(NodeHist data) {
        NodeHist aux = this.inicio;
        int count = 0;
        
        while(aux.getProx() != null) {
            if(data.equals(aux)) {
                return count;
            }
            aux = aux.getProx();
            count++;
        }
        
        return -1;
    }
    
    public int tam() {
        return this.tam;
    }

    public NodeHist elementoEm(int i) {
        boolean next = true;
        int count = 0;
        NodeHist aux = this.inicio;

        while (next) {
            if (count < i) {
                if (aux.getProx() != null) {
                    count++;
                    aux = aux.getProx();
                } else {
                    next = false;
                }
            } else if (count == i) {
                return aux;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        String lista;

        NodeHist aux = inicio;

        lista = "";
        while (aux != null) {
            lista = lista + " " + aux.getValue()+ " \n";
            aux = aux.getProx();
        }

        return lista;
    
    }
}
