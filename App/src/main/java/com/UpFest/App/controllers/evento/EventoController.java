package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.services.evento.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @PostMapping("/criar")
    public ResponseEntity<?> addEventoToDB(@RequestBody Evento evento) {

        try {
            Evento eventSaved = eventoService.addEventoToDB(evento);
            return ResponseEntity.ok("The event '" + eventSaved.getDesignacao() + "' was saved on the BD.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("/{id_evento}/editar")
    public ResponseEntity<?> editarEvento(@PathVariable Long id_evento, @RequestBody Evento eventFromReq) {

        // set ID on the event passed on the arg
        eventFromReq.setId(id_evento);

        try {
            Evento eventUpdated = eventoService.editEventOnDB(eventFromReq);
            return ResponseEntity.ok("The event with ID " + id_evento + " was updated to " + eventUpdated.getDesignacao());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getEventos() {

        try {
            List<Evento> eventsFromDB = eventoService.getEventsFromDB();
            return ResponseEntity.status(HttpStatus.OK).body(eventsFromDB);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
