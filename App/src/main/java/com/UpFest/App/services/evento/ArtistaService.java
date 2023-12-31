package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Artista;

import java.util.List;

public interface ArtistaService {

    Artista addArtistaToDB(Long id_evento, Artista artista) throws Exception;

    Artista editArtistaAtDB(Long id_evento, Long id_artista, Artista artista) throws Exception;

    List<Artista> getArtistsFromDB(Long id_evento) throws Exception;
}
