package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Evento;

import java.util.List;

public interface EventoService {
    Evento addEventoToDB(Evento evento) throws Exception;

    Evento editEventOnDB(Evento evento) throws Exception;

    List<Evento> getEventsFromDB() throws Exception;
}
