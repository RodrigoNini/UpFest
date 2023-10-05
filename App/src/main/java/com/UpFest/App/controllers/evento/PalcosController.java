package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Palco;
import com.UpFest.App.services.evento.PalcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            return ResponseEntity.ok("The Palco '" + palcoCreated.getDesignacao() + "' was added to the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("/{id_evento}/palco/{id_palco}/editar")
    public ResponseEntity<?> editPalcoAtDB(@PathVariable Long id_evento, @PathVariable Long id_palco, @RequestBody Palco palco) {

        try {
            Palco palcoUpdated = palcoService.editPalcoAtDB(id_evento, id_palco, palco);
            return ResponseEntity.ok("The Palco with ID'" + palcoUpdated.getId() + "' was updated to '" + palcoUpdated.getDesignacao() + "' on the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{id_evento}/palco/listar")
    public ResponseEntity<?> getPalcos(@PathVariable Long id_evento) {

        try {
            List<Palco> palcosFromDB = palcoService.getPalcosFromDB(id_evento);
            return ResponseEntity.status(HttpStatus.OK).body(palcosFromDB);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

}
