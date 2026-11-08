package es.ieslapuebla.tareafinal.components;

import javafx.event.Event;
import javafx.event.EventType;

public class SearchEvent extends Event {
    public static final EventType<SearchEvent> SEARCH_EVENT = new EventType<>(Event.ANY, "SEARCH_EVENT");
    private final String texto;

    public SearchEvent(String texto) {
        super(SEARCH_EVENT);
        this.texto = texto;
    }

    public String getText() {return texto;}


}
