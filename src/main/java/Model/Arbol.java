package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Arbol {
    private int tamaño;
    private Nodo nodoInicio;

    public Arbol() {
        this.tamaño=0;
    }

    //1. Esta vacio

    public boolean estaVacio(){
        Boolean vacio=false;

        if(tamaño==0){
            vacio=true;
        }
        return vacio;
    }
    public void agregarInicio(Nodo nodo){
        nodoInicio=nodo;
        tamaño++;
    }

    //2. Agregar valor

    public boolean agregarElemento(int valor){
        if (nodoInicio == null) {
            nodoInicio = new Nodo(valor);
            tamaño++;
            return true;
        }
        return agregar(nodoInicio, valor);
    }

    public boolean agregar(Nodo nodoArranque, int valor) {
        if (valor < nodoArranque.getValor()) {
            if (nodoArranque.getNodoIzquierdoSiguiente() == null) {
                nodoArranque.setNodoIzquierdoSiguiente(new Nodo(valor));
                tamaño++; //
                return true;
            }
            return agregar(nodoArranque.getNodoIzquierdoSiguiente(), valor);

        } else if (valor > nodoArranque.getValor()) {

            if (nodoArranque.getNodoDerechoSiguiente() == null) {
                nodoArranque.setNodoDerechoSiguiente(new Nodo(valor));
                tamaño++;
                return true;
            }
            return agregar(nodoArranque.getNodoDerechoSiguiente(), valor);
        } else {

            return false;
        }
    }




    //4. Existe dato
    public boolean existeDato(int valorVerificar){
        Nodo nodoArranque=nodoInicio;
        boolean resultado=verificarDato(nodoArranque,valorVerificar);
        return  resultado;

    }

    public boolean verificarDato(Nodo nodoArranque, int valorVerificar) {
      if(nodoArranque == null){
          return false;
      }
       if(nodoArranque.getValor()==valorVerificar){
          return true;
       }
      boolean ladoIzquierdo= verificarDato(nodoArranque.getNodoIzquierdoSiguiente(),valorVerificar);
       if(ladoIzquierdo==true){
           return true;
       }
       return verificarDato(nodoArranque.getNodoDerechoSiguiente(),valorVerificar);
    }

    //5. Obtener Peso
    public int obtenerPeso(){
        return tamaño;
    }

    //6. Obtener Altura
    public int obtenerAltura(){
        Nodo nodoArranque=nodoInicio;
        return altura(nodoArranque);
    }


    public int altura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }

        int alturaIzquierda = altura(nodo.getNodoIzquierdoSiguiente());
        int alturaDerecha = altura(nodo.getNodoDerechoSiguiente());

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    //7.Obtener Nivel
    public int obtenerNivel(int valor) {
        return nivel(nodoInicio, valor, 0);
    }

    public int nivel(Nodo nodoArranque, int valor, int contador) {
        if (nodoArranque == null) {
            return -1;
        }

        if (nodoArranque.getValor() == valor) {
            return contador;
        }

        int izquierdo = nivel(nodoArranque.getNodoIzquierdoSiguiente(), valor, contador + 1);
        if (izquierdo != -1) {
            return izquierdo;
        }

        return nivel(nodoArranque.getNodoDerechoSiguiente(), valor, contador + 1);
    }


    //8.Contar Hojas
    public int contarHojas(){
        int contador=0;
        Nodo nodoArranque=nodoInicio;

        int resultado=hoja(nodoArranque,contador);
        return resultado;
    }

    public int hoja(Nodo nodoArranque, int contador) {
        if(nodoArranque==null){
            return contador;
        }
        if(nodoArranque.getNodoIzquierdoSiguiente()==null && nodoArranque.getNodoDerechoSiguiente()==null){
             contador=contador+1;
        }
        contador=hoja(nodoArranque.getNodoIzquierdoSiguiente(),contador);


        contador=hoja(nodoArranque.getNodoDerechoSiguiente(),contador);
        return contador;
    }


    //9.Obtener numero menor
    public int obtenerMenor(){
        int menor=999999;
        Nodo nodoArranque=nodoInicio;
        int resultado=menor(nodoArranque,menor);
        return resultado;
    }

    public int menor(Nodo nodoArranque, int menor) {
        if(nodoArranque==null){
            return menor;
        }
        if(nodoArranque.getValor()<menor){
            menor=nodoArranque.getValor();
        }
        menor=menor(nodoArranque.getNodoIzquierdoSiguiente(),menor);

        return menor(nodoArranque.getNodoDerechoSiguiente(),menor);
    }

    //10. Obtener Amplitud
    public int calcualarAmplitud(){
        Nodo nodoArranque=nodoInicio;
        int resultado=contarNodosNiveles(nodoArranque, obtenerAltura()-1);
        return resultado;
    }


    public int contarNodosNiveles(Nodo nodoArranque, int nivel) {
        if(nodoArranque==null){
            return 0;
        }
        if(nivel==0){
            return 1;
        }

        int valorIzquierdo=contarNodosNiveles(nodoArranque.getNodoIzquierdoSiguiente(),nivel-1);
        int valorDerecho=contarNodosNiveles(nodoArranque.getNodoDerechoSiguiente(),nivel-1);

        return valorIzquierdo+valorDerecho;
    }

    //11.Obtener Nodo mayor
    public int nodoMayor(){
        Nodo nodoAranque=nodoInicio;
        int valor=0;
        int resultado=mayor(nodoAranque,valor);
        return resultado;
    }

    public int mayor(Nodo nodoAranque, int valor) {
        if(nodoAranque==null){
            return valor;
        }
        if(nodoAranque.getValor()>valor){
            valor=nodoAranque.getValor();
        }
        int valorIzquierdo=mayor(nodoAranque.getNodoIzquierdoSiguiente(),valor);
        int valorDerecho=mayor(nodoAranque.getNodoDerechoSiguiente(),valor);

        if(valorIzquierdo>valorDerecho){
            return valorIzquierdo;
        }
        return valorDerecho;

    }
    //12. metodo eliminar arbol completo
    public Boolean borrarArbol(){
        if(tamaño==0){
            tamaño=0;
            return false;
        }
        nodoInicio=null;
        return true;
    }

    //13. eliminar


    //14 Recorrer arbol inorden
    public ArrayList<Integer> recorrerListaInorden(){
        ArrayList<Integer> listaResultado=new ArrayList<>();
        Nodo nodoArranque=nodoInicio;

        return recorrerInorden(nodoArranque,listaResultado);
    }

    private ArrayList<Integer> recorrerInorden(Nodo nodoArranque, ArrayList<Integer> listaResultado) {
        if(nodoArranque==null){
            return listaResultado;
        }

        recorrerInorden(nodoArranque.getNodoIzquierdoSiguiente(),listaResultado);
        listaResultado.add(nodoArranque.getValor());
        recorrerInorden(nodoArranque.getNodoDerechoSiguiente(),listaResultado);

        return listaResultado;
    }



    //15 Recorrer arbol preorden
    public ArrayList<Integer> recorrerListaPreorden(){
        ArrayList<Integer> listaResultado=new ArrayList<>();
        Nodo nodoArranque=nodoInicio;

        return recorrerPreorden(nodoArranque,listaResultado);
    }

    private ArrayList<Integer>recorrerPreorden(Nodo nodoArranque, ArrayList listaResultado) {
        if(nodoArranque==null){
            return listaResultado;
        }
        listaResultado.add(nodoArranque.getValor());
        recorrerPreorden(nodoArranque.getNodoIzquierdoSiguiente(),listaResultado);
        recorrerPreorden(nodoArranque.getNodoDerechoSiguiente(),listaResultado);

        return listaResultado;
    }

    //16 metodo recorrer en postorden

    public ArrayList<Integer> recorrerListaPostOrden(){
        ArrayList<Integer> listaResultado=new ArrayList<>();
        Nodo nodoArranque=nodoInicio;

        return recorrerPostOrden(nodoArranque,listaResultado);
    }

    private ArrayList<Integer> recorrerPostOrden(Nodo nodoArranque, ArrayList<Integer> listaResultado) {
        if(nodoArranque==null){
            return listaResultado;
        }

        recorrerPostOrden(nodoArranque.getNodoIzquierdoSiguiente(),listaResultado);
        recorrerPostOrden(nodoArranque.getNodoDerechoSiguiente(),listaResultado);
        listaResultado.add(nodoArranque.getValor());

        return listaResultado;
    }


    //17 metodo elimnar

    public boolean eliminarElemento(int valor) {
        if (nodoInicio == null) {
            return false;
        }

        int tamañoAntes = tamaño;
        nodoInicio = eliminar(nodoInicio, valor);
        return tamaño < tamañoAntes;
    }

    private Nodo eliminar(Nodo nodoActual, int valor) {
        if (nodoActual == null) {
            return null;
        }

        if (valor < nodoActual.getValor()) {
            nodoActual.setNodoIzquierdoSiguiente(eliminar(nodoActual.getNodoIzquierdoSiguiente(), valor));
        } else if (valor > nodoActual.getValor()) {
            nodoActual.setNodoDerechoSiguiente(eliminar(nodoActual.getNodoDerechoSiguiente(), valor));
        } else {
            tamaño--;


            if (nodoActual.getNodoIzquierdoSiguiente() == null && nodoActual.getNodoDerechoSiguiente() == null) {
                return null;
            }


            if (nodoActual.getNodoIzquierdoSiguiente() == null) {
                return nodoActual.getNodoDerechoSiguiente();
            } else if (nodoActual.getNodoDerechoSiguiente() == null) {
                return nodoActual.getNodoIzquierdoSiguiente();
            }


            Nodo sucesor = encontrarMinimo(nodoActual.getNodoDerechoSiguiente());
            nodoActual.setValor(sucesor.getValor());
            nodoActual.setNodoDerechoSiguiente(eliminar(nodoActual.getNodoDerechoSiguiente(), sucesor.getValor()));
        }

        return nodoActual;
    }



    public Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getNodoIzquierdoSiguiente() != null) {
            nodo = nodo.getNodoIzquierdoSiguiente();
        }
        return nodo;
    }
//___________________________________________________________________________________________________________

    public List<NodoTabla> nodosObtenerTabla(){
        Nodo nodoArranque=nodoInicio;
        List<NodoTabla> lista=new ArrayList<>();
        return obtenerTabla(nodoArranque,lista);
    }

    private List<NodoTabla> obtenerTabla(Nodo nodoArranque, List<NodoTabla> lista) {
        if(nodoArranque==null){
            return lista;
        }
        NodoTabla nodoTabla=new NodoTabla(nodoArranque);
        nodoTabla.setNivel(obtenerNivel(nodoArranque.getValor()));
        lista.add(nodoTabla);

        obtenerTabla(nodoArranque.getNodoIzquierdoSiguiente(),lista);
        obtenerTabla(nodoArranque.getNodoDerechoSiguiente(),lista);
        return lista;

    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public Nodo getNodoInicio() {
        return nodoInicio;
    }

    public void setNodoInicio(Nodo nodoInicio) {
        this.nodoInicio = nodoInicio;
    }
}
