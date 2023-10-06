package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Palco;
import com.UpFest.App.entities.SerieBilhetes;
import com.UpFest.App.services.evento.SerieBilhetesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/evento")
public class SerieBilhetesController {

    @Autowired
    SerieBilhetesService serieBilhetesService;

    @PostMapping("{id_evento}/series_bilhetes/criar")
    public ResponseEntity<?> addSerieBilhetesToDB(@PathVariable Long id_evento, @RequestBody SerieBilhetes serieBilhetes) {

        try {
            SerieBilhetes serieBilhetesCreated = serieBilhetesService.addSerieBilhetesToDB(id_evento, serieBilhetes);
            return ResponseEntity.ok("The SerieBilhetes '" + serieBilhetesCreated.getDesignacao() + "' was added to the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("{id_evento}/series_bilhetes/{id_serie}/editar")
    public ResponseEntity<?> editSerieBilhetesAtDB(@PathVariable Long id_evento, @PathVariable Long id_serie, @RequestBody SerieBilhetes serieBilhetes) {

        try {
            SerieBilhetes serieBilhetesUpdated = serieBilhetesService.editSerieBilhetesAtDB(id_evento, id_serie, serieBilhetes);
            return ResponseEntity.ok("The SerieBilhetes with ID'" + serieBilhetesUpdated.getId() + "' was updated on the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }


}
