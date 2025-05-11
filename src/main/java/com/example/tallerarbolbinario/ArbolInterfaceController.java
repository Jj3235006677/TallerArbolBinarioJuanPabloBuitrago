package com.example.tallerarbolbinario;

import Model.Arbol;
import Model.NodoTabla;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ArbolInterfaceController {

    public TableView<NodoTabla> TableViewHijos;
    public TableColumn<NodoTabla, Integer> tableColumnPadre;
    public TableColumn<NodoTabla, Integer> tableColumnHijoIzquierdo;
    public TableColumn<NodoTabla, Integer> tableColumnHijoDerecho;
    public TableColumn<NodoTabla,Integer> tableColumnivel;


    private Arbol arbol;

    @FXML
    public void initialize() {
        arbol = new Arbol();
        tableColumnPadre.setCellValueFactory(data-> new SimpleObjectProperty<>(data.getValue().getValorPadre()));
        tableColumnivel.setCellValueFactory(data->new SimpleObjectProperty<>(data.getValue().getNivel()));
        tableColumnHijoIzquierdo.setCellValueFactory(data -> {
            Integer valor = data.getValue().getValorHijoIzquierdo();
            return new SimpleObjectProperty<>(valor != -1 ? valor : null);
        });

        tableColumnHijoDerecho.setCellValueFactory(data -> {
            Integer valor = data.getValue().getValorHijoDerecho();
            return new SimpleObjectProperty<>(valor != -1 ? valor : null);
        });


    }

    public void actualizarTabla() {
        TableViewHijos.getItems().clear();
        TableViewHijos.getItems().addAll(arbol.nodosObtenerTabla());
    }


    @FXML
    public void agregarNodo(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Agregar.fxml"));
            Parent root = fxmlLoader.load();


            AgregarController controlador = fxmlLoader.getController();

            controlador.setArbol(arbol);
            controlador.setControladorPrincipal(this);


            Stage stage = new Stage();
            stage.setTitle("Ventana Agregar");
            stage.setScene(new Scene(root));

            stage.setX(880);
            stage.setY(200);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void elimanrElemento(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Eliminar.fxml"));
            Parent root = fxmlLoader.load();


            EliminarController controlador = fxmlLoader.getController();

            controlador.setArbol(arbol);
            controlador.setControladorPrincipal(this);

            Stage stage = new Stage();
            stage.setTitle("Ventana eliminar");
            stage.setScene(new Scene(root));
            stage.setX(880);
            stage.setY(200);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void obtenerFuncionalidad(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Obtener.fxml"));
            Parent root = fxmlLoader.load();


            ObtenerController controlador = fxmlLoader.getController();

            controlador.setArbol(arbol);

            Stage stage = new Stage();
            stage.setTitle("Ventana obtener");
            stage.setScene(new Scene(root));
            stage.setX(880);
            stage.setY(200);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ImprimirFuncionalidad(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Imprimir.fxml"));
            Parent root = fxmlLoader.load();


            ImprimirController controlador = fxmlLoader.getController();

            controlador.setArbol(arbol);

            Stage stage = new Stage();
            stage.setTitle("Ventana eliminar");
            stage.setScene(new Scene(root));
            stage.setX(880);
            stage.setY(200);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verificarFuncionalidad(ActionEvent actionEvent) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Verificar.fxml"));
            Parent root = fxmlLoader.load();


            VerificarController controlador = fxmlLoader.getController();

            controlador.setArbol(arbol);

            Stage stage = new Stage();
            stage.setTitle("Ventana eliminar");
            stage.setScene(new Scene(root));
            stage.setX(880);
            stage.setY(200);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


