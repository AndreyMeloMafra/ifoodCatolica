package catolicafood.utils;

import catolicafood.exceptions.InvalidPosException;

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
        data.setProx(inicio);
        inicio = data;
        
        if (fim == null){
            fim = data;
        }
       
        tam++;
    }

    public void addFim(NodeHist data) {
        if (inicio == null){
            inicio = data;
        } else {
            fim.setProx(data);
        }
        fim = data;
        
        tam++;
    }

    public void addPos(NodeHist data, int pos) throws InvalidPosException {
        if(pos < 0 || pos > this.tam) {
            throw new InvalidPosException("Posição inválida");
        }
        if (pos == 0) {
            data.setProx(this.inicio);
            inicio = data;
        } else {
            NodeHist iterador = inicio;
            for(int i = 0; i < (pos - 1); i++){
                iterador = iterador.getProx();
            }
            data.setProx(iterador.getProx());
            iterador.setProx(data);
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
            lista = lista + " " + aux.getValue().getName() + " por R$" + aux.getValue().getValue() + " \n";
            aux = aux.getProx();
        }

        return lista;
    
    }
}
