package com.UpFest.App.services;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.repositories.EventoRepository;
import jdk.jfr.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Evento editEventOnDB(Evento eventoFromRequest) throws Exception {

        Long id = eventoFromRequest.getId();

        if (id == null) {
            throw new Exception("ID cannot be null");
        }

        Optional<Evento> eventOnDB = eventoRepository.findById(id);

        if (eventOnDB.isEmpty()) {
            throw new Exception("ID " + id + " does not exist in the DB");
        }

        Evento eventToSave = eventOnDB.get();
        BeanUtils.copyProperties(eventoFromRequest, eventToSave, "id");

        return eventoRepository.save(eventToSave);

    }

}
