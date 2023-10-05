package com.UpFest.App.services;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImp implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public boolean addEventoToDB(Evento evento) {

        String nameOfEvent = evento.getDesignacao();

        if (nameOfEvent == null) {
            return false;
        }

        Evento eventoSaved = eventoRepository.save(evento);
        return true;
    }
}
