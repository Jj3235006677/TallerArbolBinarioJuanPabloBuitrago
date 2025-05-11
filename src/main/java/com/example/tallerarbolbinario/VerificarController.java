package com.example.tallerarbolbinario;

import Model.Arbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class VerificarController {

    public ComboBox<String> comboBoxSeleccion;
    public TextField textFieldValorVerificar;


    private Arbol arbol;

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    @FXML
    public void initialize() {

        comboBoxSeleccion.getItems().addAll("Arbol vacio", "Dato contenido");

        comboBoxSeleccion.setOnAction(event -> {
            String seleccion = comboBoxSeleccion.getValue();
            if ("Dato contenido".equals(seleccion)) {

                textFieldValorVerificar.setVisible(true);
            } else {

                textFieldValorVerificar.setVisible(false);
            }
        });

    }

    public void obtenerFuncionalidad(ActionEvent actionEvent) {
        String selecion = comboBoxSeleccion.getValue();

        if (selecion.equals("Arbol vacio")) {
            if(arbol.estaVacio()==false){
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Arbol vacio");
                alerta.setHeaderText(null);
                alerta.setContentText("FALSO, el arbol NO esta vacio " );
                alerta.showAndWait();
            }else {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Arbol vacio");
                alerta.setHeaderText(null);
                alerta.setContentText("VERDADERO, el arbol SI esta vacio " );
                alerta.showAndWait();

            }


        } else if (selecion.equals("Dato contenido")) {
           int valor=Integer.parseInt(textFieldValorVerificar.getText());
           if(arbol.existeDato(valor)){
               Alert alerta = new Alert(Alert.AlertType.INFORMATION);
               alerta.setTitle("Existe dato");
               alerta.setHeaderText(null);
               alerta.setContentText("VERDADERO, el dato SI esta contenido en el arbol " );
               alerta.showAndWait();
           }else {
               Alert alerta = new Alert(Alert.AlertType.INFORMATION);
               alerta.setTitle("Existe dato");
               alerta.setHeaderText(null);
               alerta.setContentText("FALSO, el dato NO esta contenido en el arbol " );
               alerta.showAndWait();
           }

        }
    }
}
