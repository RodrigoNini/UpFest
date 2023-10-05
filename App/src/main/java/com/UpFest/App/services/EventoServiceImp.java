package com.UpFest.App.services;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.repositories.EventoRepository;
import jdk.jfr.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImp implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Evento addEventoToDB(Evento evento) throws Exception {

        System.out.println(evento);
        String nameOfEvent = evento.getDesignacao();

        if (nameOfEvent == null || nameOfEvent.isEmpty()) {
            throw new Exception("'designacao' of evento can't be empty.");
        }

        return eventoRepository.save(evento);
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

    @Override
    public List<Evento> getEventsFromDB() throws Exception {

        List<Evento> eventsFromDB = eventoRepository.findAll();

        if (eventsFromDB.isEmpty()) {
            throw new Exception("No events in the DB.");
        }

        return eventsFromDB;
    }

}
