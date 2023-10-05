package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Palco;
import com.UpFest.App.services.evento.PalcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/evento")
public class PalcosController {

    @Autowired
    PalcoService palcoService;

    @PostMapping("/{id_evento}/palco/criar")
    public ResponseEntity<?> addPalcoToDB(@PathVariable Long id_evento, @RequestBody Palco palco) {

        try {
            Palco palcoCreated = palcoService.addPalcoToDB(id_evento, palco);
            return ResponseEntity.ok("The Palco '" + palco.getDesignacao() + "' was added to the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
