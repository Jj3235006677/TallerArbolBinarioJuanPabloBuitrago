package Model;

public class NodoLista {
    private int valor;
    private Nodo nodoSiguiete;

    public NodoLista(int valor) {
        this.valor = valor;
        this.nodoSiguiete=null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getNodoSiguiete() {
        return nodoSiguiete;
    }

    public void setNodoSiguiete(Nodo nodoSiguiete) {
        this.nodoSiguiete = nodoSiguiete;
    }
}
