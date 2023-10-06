package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Artista;
import com.UpFest.App.services.evento.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/evento")
public class ArtistaController {

    @Autowired
    ArtistaService artistaService;

    @PostMapping("/{id_evento}/artistas/criar")
    public ResponseEntity<?> addArtistaToDB(@PathVariable Long id_evento, @RequestBody Artista artista) {

        try {
            Artista artistaCreated = artistaService.addArtistaToDB(id_evento, artista);
            return ResponseEntity.ok("The Artista '" + artistaCreated.getNome() + "' was added to the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
