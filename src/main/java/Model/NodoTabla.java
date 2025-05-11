package Model;

public class NodoTabla {
    private int valorPadre;
    private int valorHijoIzquierdo;
    private int valorHijoDerecho;
    private int nivel;


    public NodoTabla(Nodo nodo) {
        this.valorPadre = nodo.getValor();


        if (nodo.getNodoIzquierdoSiguiente() == null) {
            this.valorHijoIzquierdo = -1;
        } else {
            this.valorHijoIzquierdo = nodo.getNodoIzquierdoSiguiente().getValor();
        }


        if (nodo.getNodoDerechoSiguiente() == null) {
            this.valorHijoDerecho = -1;
        } else {
            this.valorHijoDerecho = nodo.getNodoDerechoSiguiente().getValor();
        }

    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getValorPadre() {
        return valorPadre;
    }

    public void setValorPadre(int valorPadre) {
        this.valorPadre = valorPadre;
    }

    public int getValorHijoIzquierdo() {
        return valorHijoIzquierdo;
    }

    public void setValorHijoIzquierdo(int valorHijoIzquierdo) {
        this.valorHijoIzquierdo = valorHijoIzquierdo;
    }

    public int getValorHijoDerecho() {
        return valorHijoDerecho;
    }

    public void setValorHijoDerecho(int valorHijoDerecho) {
        this.valorHijoDerecho = valorHijoDerecho;
    }
}
