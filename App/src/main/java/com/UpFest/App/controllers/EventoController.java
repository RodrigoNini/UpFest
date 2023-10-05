package com.UpFest.App.controllers;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;


    @PostMapping("/criar")
    public ResponseEntity<?> addEventoToDB(@RequestBody Evento evento) {

        if (eventoService.addEventoToDB(evento)) {
            return ResponseEntity.ok("The event '" + evento.getDesignacao() + "' was saved on the BD.");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid event name.");

    }

    @PostMapping("/{id_evento}/editar")
    public ResponseEntity<?> editarEvento(@PathVariable Long id_evento, @RequestBody Evento eventFromReq) {

        // set ID on the event passed on the arg
        eventFromReq.setId(id_evento);

        try {
            Evento eventUpdated = eventoService.editEventOnDB(eventFromReq);
            return ResponseEntity.ok("The event with ID " + id_evento + " was updated to " + eventFromReq.getDesignacao());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
