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
public class ListItems {

    private NodeItems inicio;
    private NodeItems fim;
    private int tam;

    public ListItems() {
        this.inicio = null;
        this.fim = null;
        tam = 0;
    }

    public NodeItems getInicio() {
        return inicio;
    }

    public NodeItems getFim() {
        return fim;
    }
    
    //Add functions
    public void addInicio(NodeItems data) {
        this.inicio = data;

        if (this.tam == 0) {
            this.fim = this.inicio;
        }
       
        tam++;
    }

    public void addFim(NodeItems data) {
        if (this.tam == 0) {
            addInicio(data);
        } else {
            this.fim.setProx(data);
            this.fim = data;
        }
        tam++;
    }

    public void addPos(NodeItems data, int pos) {
        if (pos == 0) {
            data.setProx(this.inicio.getProx());
            inicio = data;
        } else {
            NodeItems aux = elementoEm(pos - 1);
            aux.setProx(data);
        }
        tam++;
    }
    
    //Remove function
    public void remover(NodeItems data){
        int pos = search(data);
        NodeItems anterior = elementoEm(pos - 1);
        NodeItems proximo = elementoEm(pos + 1);
        anterior.setProx(proximo);
    }
    
    //Search function
    public int search(NodeItems data) {
        NodeItems aux = this.inicio;
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

    public NodeItems elementoEm(int i) {
        boolean next = true;
        int count = 0;
        NodeItems aux = this.inicio;

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

        NodeItems aux = inicio;

        lista = "";
        while (aux != null) {
            lista = lista + " " + aux.getValue()+ " \n";
            aux = aux.getProx();
        }

        lista += " tamanho: " + tam;
        return lista;
    
    }
}
