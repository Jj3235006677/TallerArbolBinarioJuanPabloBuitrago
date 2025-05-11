package com.example.tallerarbolbinario;

import Model.Arbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ImprimirController {

    public ComboBox<String> comboBoxSeleccion;
    public TextField textFieldValorVerificar;


    private Arbol arbol;

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    @FXML
    public void initialize() {

        comboBoxSeleccion.getItems().addAll("Inorden", "Preorden", "Postorden");







    }

    public void obtenerFuncionalidad(ActionEvent actionEvent) {
        String selecion = comboBoxSeleccion.getValue();

        if (selecion.equals("Inorden")) {
            ArrayList<Integer> listaValores=arbol.recorrerListaInorden();

            String valorImprmir="";

            for(int i=0;i<=listaValores.size()-1;i++){
                valorImprmir+=listaValores.get(i);

                if (i < listaValores.size() - 1) {
                    valorImprmir += ", ";
                }

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Recorrido inorden");
            alerta.setHeaderText(null);
            alerta.setContentText("El recorrido en inorde es " + valorImprmir);
            alerta.showAndWait();

        } else if (selecion.equals("Preorden")) {
            ArrayList<Integer> listaValores=arbol.recorrerListaPreorden();

            String valorImprmir="";

            for(int i=0;i<=listaValores.size()-1;i++){
                valorImprmir+=listaValores.get(i);

                if (i < listaValores.size() - 1) {
                    valorImprmir += ", ";
                }

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Recorrido preorden");
            alerta.setHeaderText(null);
            alerta.setContentText("El recorrido en preorden es " + valorImprmir);
            alerta.showAndWait();

        } else if (selecion.equals("Postorden")) {
            ArrayList<Integer> listaValores=arbol.recorrerListaPostOrden();

            String valorImprmir="";

            for(int i=0;i<=listaValores.size()-1;i++){
                valorImprmir+=listaValores.get(i);

                if (i < listaValores.size() - 1) {
                    valorImprmir += ", ";
                }

            }
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Recorrido postorden");
            alerta.setHeaderText(null);
            alerta.setContentText("El recorrido en postorden es " + valorImprmir);
            alerta.showAndWait();

        }
    }
}
