package com.example.tallerarbolbinario;

import Model.Arbol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.TreeSet;

public class ObtenerController {

    public ComboBox<String> comboBoxSeleccion;
    public TextField textFieldElemeno;

    private Arbol arbol;

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    @FXML
    public void initialize() {

        comboBoxSeleccion.getItems().addAll("Peso", "Altura", "Nivel", "Numero de hojas", "Numero mayor", "Numero menor");


        textFieldElemeno.setVisible(false);


        comboBoxSeleccion.setOnAction(event -> {
            String seleccion = comboBoxSeleccion.getValue();
            if ("Nivel".equals(seleccion)) {

                textFieldElemeno.setVisible(true);
                textFieldElemeno.clear();
            } else {

                textFieldElemeno.setVisible(false);
            }
        });
    }

    public void obtenerFuncionalidad(ActionEvent actionEvent) {
        String selecion = comboBoxSeleccion.getValue();

        if (selecion.equals("Peso")) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("El peso del árbol es");
            alerta.setHeaderText(null); // si no quieres un título grande
            alerta.setContentText("El peso del árbol es " + arbol.obtenerPeso());
            alerta.showAndWait();

        } else if (selecion.equals("Altura")) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("La altura del árbol ");
            alerta.setHeaderText(null);
            alerta.setContentText("La altura del árbol es " + arbol.obtenerAltura());
            alerta.showAndWait();

        } else if (selecion.equals("Nivel")) {
            int valor=Integer.parseInt(textFieldElemeno.getText());
            int resultado=arbol.obtenerNivel(valor);
            textFieldElemeno.clear();
            if(resultado<0){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Valor no encontrado");
                alerta.setHeaderText(null);
                alerta.setContentText("El valor "+valor+" no se encuentra en el arbol" );
                alerta.showAndWait();
            }else {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("El nivel arbol ");
                alerta.setHeaderText(null);
                alerta.setContentText("El nivel del nodo " + valor + " es " + arbol.obtenerNivel(valor));
                alerta.showAndWait();
            }
           
        } else if (selecion.equals("Numero de hojas")) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("El número de hojas del árbol es ");
            alerta.setHeaderText(null);
            alerta.setContentText("El número de hojas es " + arbol.contarHojas());
            alerta.showAndWait();

        } else if (selecion.equals("Numero mayor")) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Número mayor");
            alerta.setHeaderText(null);
            alerta.setContentText("El número mayor es " + arbol.nodoMayor());
            alerta.showAndWait();

        } else if (selecion.equals("Numero menor")) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Número menor");
            alerta.setHeaderText(null);
            alerta.setContentText("El número menor es " + arbol.obtenerMenor());
            alerta.showAndWait();
        }
    }
}
