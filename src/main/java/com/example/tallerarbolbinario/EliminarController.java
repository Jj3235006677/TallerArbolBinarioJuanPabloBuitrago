package com.example.tallerarbolbinario;

import Model.Arbol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class EliminarController {


    private Arbol arbol;
    public TextField textFieldValorEliminar;
    private ArbolInterfaceController controladorPrincipal;


    public void setArbol(Arbol arbol){
        this.arbol=arbol;
    }
    @FXML
    public void initialize() {
    }


    public void EliminarElemento(ActionEvent actionEvent) {
        int valorObtenido=Integer.parseInt(textFieldValorEliminar.getText());
        if(arbol.eliminarElemento(valorObtenido)){
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Exito");
            alerta.setHeaderText(null);
            alerta.setContentText("Elemento eliminado correctamente.");
            alerta.showAndWait();
            System.out.println(arbol.getTamaño());
            controladorPrincipal.actualizarTabla();
            textFieldValorEliminar.clear();
        }else {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Elemento no encontrado");
            alerta.showAndWait();
        }

    }

    public void setControladorPrincipal(ArbolInterfaceController controlador) {
        this.controladorPrincipal = controlador;
    }
}
