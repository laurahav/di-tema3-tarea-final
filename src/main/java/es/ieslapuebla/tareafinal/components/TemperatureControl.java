package es.ieslapuebla.tareafinal.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TemperatureControl extends VBox {
    // Definimos los valores mínimos, máximos y por defecto de la temperatura.
    private static final int MIN = 0;
    private static final int MAX = 40;
    private static final int DEFAULT = 20;

    private final Label tituloTemperaturaLabel = new Label("Temperatura");
    // Creamos la propiedad donde va a ir almacenada la variable de temperatura y el label que la va a mostrar
    private final IntegerProperty temperature = new SimpleIntegerProperty(this, "temperature", DEFAULT);
    private final Label temperatureLabel = new Label();

    // Creamos los botones para incrementar, disminuir o resetear la temperatura.
    private final Button menosButton = new Button("-");
    private final Button masButton = new Button("+");
    private final Button resetButton = new Button("Reset");

    public TemperatureControl() {
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        tituloTemperaturaLabel.setId("label-titulo");
        temperatureLabel.setId("temperatura");
        menosButton.setId("boton");
        masButton.setId("boton");
        resetButton.setId("boton");


        // Enlazamos el label con la propiedad de temperatura.
        temperatureLabel.textProperty().bind(temperature.asString("%d ºC"));

        // Definimos lo que deben realizar los botones.
        menosButton.setOnAction(event -> disminuir());
        masButton.setOnAction(event -> incrementar());
        resetButton.setOnAction(event -> reset());

        // Los agrupamos todos en un HBox
        HBox botones = new HBox(10, menosButton, masButton, resetButton);

        botones.setAlignment(Pos.CENTER);

        // Añadimos como componentes del TemperatureControl, un label con el texto de
        // "Temperatura", el label donde aparece la temperatura y los botones.
        getChildren().addAll(tituloTemperaturaLabel, temperatureLabel, botones);
    }

    // Creamos los getter y los setters. También el métod.o que devuelve la propiedad
    public int getTemperature() {
        return temperature.get();
    }

    public void setTemperature(int temp) {
        if(temp < MIN) {
            temp = MIN;
        }

        if (temp > MAX) {
            temp = MAX;
        }

        temperature.set(temp);
    }

    public IntegerProperty temperatureProperty() {return temperature;}


    // Creamos los métodos que realizan los botones.
    public void disminuir() {
        setTemperature(getTemperature() - 1);
    }

    public void incrementar() {
        setTemperature(getTemperature() + 1);
    }

    public void reset() {
        setTemperature(DEFAULT);
    }

}
