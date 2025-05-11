package com.example.tallerarbolbinario;

import Model.Arbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgregarController {


    private Arbol arbol;
    public TextField textFieldValorNuevo;
    private ArbolInterfaceController controladorPrincipal;







    public void setArbol(Arbol arbol){
        this.arbol=arbol;
    }
    @FXML
    public void initialize() {
    }


    public void AgregarElemento(ActionEvent actionEvent) {
        int valorObtenido=Integer.parseInt(textFieldValorNuevo.getText());
        if(arbol.agregarElemento(valorObtenido)){
            controladorPrincipal.actualizarTabla();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exito");
            alerta.setHeaderText(null);
            alerta.setContentText("Elemento agregado correctamente.");
            alerta.showAndWait();

            textFieldValorNuevo.clear();
        }else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Elemento repetido");
            alerta.showAndWait();
        }

    }

    public void setControladorPrincipal(ArbolInterfaceController controlador) {
        this.controladorPrincipal = controlador;

    }
}
