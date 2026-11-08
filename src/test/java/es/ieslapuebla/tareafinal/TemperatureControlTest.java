package es.ieslapuebla.tareafinal;

import es.ieslapuebla.tareafinal.components.TemperatureControl;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class TemperatureControlTest {
    @BeforeAll
    public static void iniciarJavaFX() {
        try {
            Platform.startup(() -> { });
        } catch (IllegalStateException e) {
            e.getStackTrace();
        }
    }

    @Test
    void testValorPorDefecto() {
        TemperatureControl temperatureControl = new TemperatureControl();
        assertEquals(20, temperatureControl.getTemperature());
    }

    @Test
    void testAsignarTemperaturaDirectamente(FxRobot robot) {
        TemperatureControl temperatureControl = new TemperatureControl();

        robot.interact(() -> {
            temperatureControl.setTemperature(25);
        });

        // Comprobamos que se asignó correctamente
        assertEquals(25, temperatureControl.getTemperature());
    }

    @Test
    void testRespetarMinimo(FxRobot robot) {
        TemperatureControl temperatureControl = new TemperatureControl();

        robot.interact(() -> {
            // Intentamos asignar un valor por debajo del mínimo (MIN = 0)
            temperatureControl.setTemperature(-5);
        });

        // Debe limitarse automáticamente al mínimo (0)
        assertEquals(0, temperatureControl.getTemperature());
    }

    @Test
    void testRespetarMaximo(FxRobot robot) {
        TemperatureControl temperatureControl = new TemperatureControl();

        robot.interact(() -> {
            // Intentamos asignar un valor por encima del máximo (MAX = 40)
            temperatureControl.setTemperature(50);
        });

        // Debe limitarse automáticamente al máximo (40)
        assertEquals(40, temperatureControl.getTemperature());
    }
}
