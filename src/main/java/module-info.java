module es.ieslapuebla.tareafinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;

    opens es.ieslapuebla.tareafinal to javafx.fxml, org.junit.platform.commons, org.junit.jupiter.api;
    exports es.ieslapuebla.tareafinal;
    exports es.ieslapuebla.tareafinal.components;
    opens es.ieslapuebla.tareafinal.components to javafx.fxml;
}