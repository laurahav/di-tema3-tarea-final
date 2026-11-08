package es.ieslapuebla.tareafinal.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RatingControl extends VBox {
    // Creamos la propiedad que va a tener almacenado el rating, en este caso un entero
    // el componente que va a mostrar esa propiedad.
    private final IntegerProperty rating = new SimpleIntegerProperty(this, "rating", 0);
    private final Label labelRating = new Label();

    public RatingControl() {
        setSpacing(10);
        setAlignment(Pos.CENTER);

        labelRating.setId("label-titulo");
        // Enlazamos la propiedad con el componente:
        labelRating.textProperty().bind(rating.asString("Valoración: %d"));

        // Creamos el componente que va a contener los botones:
        HBox botones = new HBox(5);
        botones.setAlignment(Pos.CENTER);

        // Creamos los 5 botones:
        for(int i = 1; i <= 5; i++) {
            final int valor = i;
            // Le asignamos el texto del botón
            Button boton = new Button(String.valueOf(i));
            boton.setId("boton");
            // Le ponemos que al activarlo, realice el métod.o de setRating(int valor)
            boton.setOnAction(event -> setRating(valor));
            // Lo añadimos como componente dentro del HBox que creamos arriba
            botones.getChildren().add(boton);
        }

        // Añadimos tanto el componente que muestra el rating como los botones creados como componentes
        // de RatingControl()
        getChildren().addAll(labelRating,botones);
    }

    // Creamos los getter y los setters

    public int getRating() {
        return rating.get();
    }

    public void setRating(int value) {
        if (value >= 0 && value <= 5 && getRating() != value) {
            rating.set(value);
            fireEvent(new RatingChangedEvent(value));
        }
    }

    public IntegerProperty ratingProperty() {
        return rating;
    }
}
