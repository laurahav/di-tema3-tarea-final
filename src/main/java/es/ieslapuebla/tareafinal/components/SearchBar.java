package es.ieslapuebla.tareafinal.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchBar extends HBox {
    private final StringProperty text = new SimpleStringProperty(this, "text", "");
    private final TextField txtBuscar = new TextField();

    private final Button btnBuscar = new Button("Buscar");

    public SearchBar() {
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        txtBuscar.setId("buscar");
        btnBuscar.setId("boton");

        txtBuscar.setPromptText("Buscando...");
        text.bindBidirectional(txtBuscar.textProperty());

        btnBuscar.setOnAction(event -> setText(text.get()));
        getChildren().addAll(txtBuscar, btnBuscar);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String value) {
        text.set(value);
        fireEvent(new SearchEvent(value));
    }

    public StringProperty textProperty() {return text;}
}
