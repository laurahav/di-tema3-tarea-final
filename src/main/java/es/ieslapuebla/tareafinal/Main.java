package es.ieslapuebla.tareafinal;

import es.ieslapuebla.tareafinal.components.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        UserCard userCard = new UserCard();
        userCard.setNombre("Laura Havadtai");
        userCard.setEmail("laurahavadtai@gmail.com");

        TemperatureControl temperatureControl = new TemperatureControl();
        RatingControl ratingControl = new RatingControl();

        SearchBar searchBar = new SearchBar();
        Label searchedWord = new Label("No se han realizado búsquedas aún.");
        searchedWord.setId("resultado");
        searchBar.addEventHandler(SearchEvent.SEARCH_EVENT, event -> {
            String palabra = event.getText();
            searchedWord.setText("Última palabra buscada: " + palabra);
        });
        VBox search = new VBox(0);
        search.setAlignment(Pos.CENTER);
        search.getChildren().addAll(searchBar, searchedWord);

        Button saveButton = new Button("Guardar");
        saveButton.setId("boton");
        Label saveLabel = new Label();
        saveLabel.setId("resultado");
        saveButton.setOnAction(event -> {
            saveLabel.setText("Usuario guardado.");
        });
        VBox save = new VBox(5);
        save.setAlignment(Pos.CENTER);
        save.getChildren().addAll(saveButton, saveLabel);


        VBox vBox = new VBox(10);
        vBox.setId("principal");
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().addAll(userCard, temperatureControl, ratingControl, search, save);

        Scene scene = new Scene(vBox, 450, 600);
        scene.getStylesheets().add(getClass().getResource("styles/styles.css").toExternalForm());
        stage.setTitle("Proyecto Final");
        stage.setScene(scene);
        stage.show();
    }
}
