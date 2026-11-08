package es.ieslapuebla.tareafinal;

import es.ieslapuebla.tareafinal.components.RatingControl;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class RatingControlTest {
    @BeforeAll
    public static void iniciarJavaFX() {
        try {
            Platform.startup(() -> { });
        } catch (IllegalStateException e) {
            e.getStackTrace();
        }
    }

    @Test
    void testValorInicial() {
        RatingControl ratingControl = new RatingControl();

        assertEquals(0, ratingControl.getRating());

        // Comprobamos que el texto del label muestra correctamente el formato inicial
        Label label = (Label) ratingControl.lookup("#label-titulo");
        assertEquals("Valoración: 0", label.getText());
    }

    @Test
    void testSettersYBindings(FxRobot robot) {
        RatingControl ratingControl = new RatingControl();

        robot.interact(() -> {
            ratingControl.setRating(4);
        });

        assertEquals(4, ratingControl.getRating());

        Label label = (Label) ratingControl.lookup("#label-titulo");
        assertEquals("Valoración: 4", label.getText());
    }

    @Test
    void testCreacionDeBotones() {
        RatingControl ratingControl = new RatingControl();

        var botones = ratingControl.lookupAll("#boton");
        assertEquals(5, botones.size(), "Debe haber exactamente 5 botones de valoración");
    }


    @Test
    void testRangoValidoRating(FxRobot robot) {
        RatingControl ratingControl = new RatingControl();

        robot.interact(() -> {
            ratingControl.setRating(6);
        });
        assertEquals(0, ratingControl.getRating());

        robot.interact(() -> {
            ratingControl.setRating(-1);
        });

        assertEquals(0, ratingControl.getRating());

        robot.interact(() -> {
            ratingControl.setRating(3);
        });

        assertEquals(3, ratingControl.getRating());
    }
}
