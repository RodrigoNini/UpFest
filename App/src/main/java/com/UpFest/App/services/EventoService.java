package com.UpFest.App.services;

import com.UpFest.App.entities.Evento;

public interface EventoService {

    boolean addEventoToDB(Evento evento);

    Evento editEventOnDB(Evento evento) throws Exception;

}
