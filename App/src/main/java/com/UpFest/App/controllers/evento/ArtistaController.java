package com.UpFest.App.controllers.evento;

import com.UpFest.App.entities.Artista;
import com.UpFest.App.services.evento.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{id_evento}/artistas/{id_artista}/editar")
    public ResponseEntity<?> editArtistaAtDB(@PathVariable Long id_evento, @PathVariable Long id_artista, @RequestBody Artista artista) {

        try {
            Artista artistaUpdated = artistaService.editArtistaAtDB(id_evento, id_artista, artista);
            return ResponseEntity.ok("The Artista '" + artistaUpdated.getNome() + "' was updated to the Event with ID " + id_evento + " on the DB.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{id_evento}/artistas/listar")
    public ResponseEntity<?> getArtistasFromDB(@PathVariable Long id_evento) {

        try {
            List<Artista> artistasFromDB = artistaService.getArtistsFromDB(id_evento);
            return ResponseEntity.status(HttpStatus.OK).body(artistasFromDB);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
