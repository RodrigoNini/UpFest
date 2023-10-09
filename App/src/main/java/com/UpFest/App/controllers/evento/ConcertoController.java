package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Concerto;
import com.UpFest.App.entities.ConcertoDTO;
import com.UpFest.App.entities.ConcertoDTOResponse;
import com.UpFest.App.entities.Palco;
import com.UpFest.App.services.evento.ConcertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/evento")
public class ConcertoController {

    @Autowired
    ConcertoService concertoService;

    @PostMapping("/{id_evento}/concertos/criar")
    public ResponseEntity<?> addConcertoToDB(@PathVariable Long id_evento, @RequestBody ConcertoDTO concertoDTO) {

        try {
            Concerto concertoCreated = concertoService.addConcertoToDB(id_evento, concertoDTO);
            return ResponseEntity.ok("The Concerto for the Artist '" + concertoCreated.getArtista().getNome() + "' at the Palco '" + concertoCreated.getPalco().getDesignacao() + "' was added to the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("/{id_evento}/concertos/{id_concerto}/editar")
    public ResponseEntity<?> editConcertoAtDB(@PathVariable Long id_evento, @PathVariable Long id_concerto, @RequestBody ConcertoDTO concertoDTO) {

        try {
            Concerto concertoUpdated = concertoService.editConcertoAtDB(id_evento, id_concerto, concertoDTO);
            return ResponseEntity.ok("The Concerto for the Artist '" + concertoUpdated.getArtista().getNome() + "' at the Palco '" + concertoUpdated.getPalco().getDesignacao() + "' was updated on the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id_evento}/concertos/listar")
    public ResponseEntity<?> getConcertos(@PathVariable Long id_evento) {

        try {
            List<ConcertoDTOResponse> concertosFromDB = concertoService.getConcertosFromDB(id_evento);
            return ResponseEntity.status(HttpStatus.OK).body(concertosFromDB);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
