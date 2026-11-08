package es.ieslapuebla.tareafinal.components;

import javafx.event.Event;
import javafx.event.EventType;

public class RatingChangedEvent extends Event {
    // Creamos el evento como tal:
    public static final EventType<RatingChangedEvent> RATING_CHANGED = new EventType<>(Event.ANY, "RATING_CHANGED");
    // El valor que tiene el rating
    private final int rating;


    public RatingChangedEvent(int rating) {
        // Invocamos el constructor de Event y le asignamos como tipo RATING_CHANGED.
        // A su vez, el número que le pasamos como parámetro se lo asignamos como rating.
        super(RATING_CHANGED);
        this.rating = rating;
    }

    // Creamos el getter
    public int getRating() {
        return rating;
    }
}
