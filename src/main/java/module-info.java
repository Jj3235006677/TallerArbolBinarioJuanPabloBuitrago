module com.example.tallerarbolbinario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tallerarbolbinario to javafx.fxml;
    exports com.example.tallerarbolbinario;
}