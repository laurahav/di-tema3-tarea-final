package es.ieslapuebla.tareafinal.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UserCard extends VBox {
    // Creamos las propiedades donde van a ir almacenados el nombre y el email
    private final StringProperty nombre = new SimpleStringProperty(this, "nombre", "");
    private final StringProperty email = new SimpleStringProperty(this, "email", "");
    // Creamos los componentes que muestran estos datos
    private final Label nombreLabel = new Label();
    private final Label emailLabel = new Label();

    private final Label tituloNombre = new Label("Nombre: ");
    private final Label tituloEmail = new Label("Email: ");

    public UserCard() {

        setSpacing(5);
        setPadding(new Insets(15));
        //setAlignment(Pos.CENTER);

        tituloNombre.setId("label-titulo");
        tituloEmail.setId("label-email");
        nombreLabel.setId("nombre");
        emailLabel.setId("email");

        // Enlazamos las propiedades con el componente que las va a mostrar
        nombreLabel.textProperty().bind(nombre);
        emailLabel.textProperty().bind(email);

        // Especificamos que elementos componen el nuevo componente UserCard
        getChildren().addAll(tituloNombre, nombreLabel, tituloEmail, emailLabel);
    }

    // Creamos los getters y los setters y los métodos de las nuevas propiedades creadas

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String value) {
        nombre.set(value);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public StringProperty emailProperty() {
        return email;
    }

}
