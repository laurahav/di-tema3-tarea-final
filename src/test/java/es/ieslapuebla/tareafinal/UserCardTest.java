package es.ieslapuebla.tareafinal;

import es.ieslapuebla.tareafinal.components.UserCard;
import javafx.application.Platform;
import javafx.scene.control.Label;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;

@ExtendWith(ApplicationExtension.class)
public class UserCardTest {
    @BeforeAll
    public static void iniciarJavaFX() {
        try {
            Platform.startup(() -> { });
        } catch (IllegalStateException e) {
            e.getStackTrace();
        }
    }

    // Test para comprobar que los valores iniciales del UserCard están vacíos
    @Test
    void valoresIniciales() {
        UserCard userCard = new UserCard();

        assertEquals("", userCard.getNombre());
        assertEquals("", userCard.getEmail());

        // comprobamos también que los labels que muestran dichas propiedades están vacíos
        Label nombreLabel = (Label) userCard.lookup("#nombre");
        Label emailLabel = (Label) userCard.lookup("#email");

        assertEquals("", nombreLabel.getText());
        assertEquals("", emailLabel.getText());
    }

    // Test para comprobar que cuando le asignamos algo, realmente lo muestra en la pantalla
    @Test
    void probarModificacionDeDatosYEnlaces(FxRobot robot) {
        UserCard userCard = new UserCard();

        robot.interact(() -> {
            userCard.setNombre("Juan Pérez");
            userCard.setEmail("juan.perez@example.com");
        });

        // Comprobamos los getters
        assertEquals("Juan Pérez", userCard.getNombre());
        assertEquals("juan.perez@example.com", userCard.getEmail());
    }

    // Test para probar que todos los id se han asignado correctamente
    @Test
    void testAsignacionDeIdsCss() {
        UserCard userCard = new UserCard();

        assertNotNull(userCard.lookup("#label-titulo"));
        assertNotNull(userCard.lookup("#label-email"));
        assertNotNull(userCard.lookup("#nombre"));
        assertNotNull(userCard.lookup("#email"));
    }

    // Test para probar que los 4 elementos que tiene el componente en el código están correctamente contenidos dentro de el
    @Test
    void testEstructuraDeHijos() {
        UserCard userCard = new UserCard();

        assertEquals(4, userCard.getChildren().size());
    }
}
