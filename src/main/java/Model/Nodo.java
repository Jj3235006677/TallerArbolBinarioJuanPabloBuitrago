package Model;

public class Nodo {
    private int valor;
    private Nodo nodoDerechoSiguiente;
    private Nodo nodoIzquierdoSiguiente;

    public Nodo(int valor) {
        this.valor=valor;
        this.nodoDerechoSiguiente =null;
        this.nodoIzquierdoSiguiente = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Nodo getNodoDerechoSiguiente() {
        return nodoDerechoSiguiente;
    }

    public void setNodoDerechoSiguiente(Nodo nodoDerechoSiguiente) {
        this.nodoDerechoSiguiente = nodoDerechoSiguiente;
    }

    public Nodo getNodoIzquierdoSiguiente() {
        return nodoIzquierdoSiguiente;
    }

    public void setNodoIzquierdoSiguiente(Nodo nodoIzquierdoSiguiente) {
        this.nodoIzquierdoSiguiente = nodoIzquierdoSiguiente;
    }
}
