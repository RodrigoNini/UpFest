package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Artista;
import com.UpFest.App.entities.Evento;
import com.UpFest.App.repositories.evento.ArtistaRepository;
import com.UpFest.App.repositories.evento.EventoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ArtistaServiceImp implements ArtistaService {

    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Artista addArtistaToDB(Long id_evento, Artista artistaFromReq) throws Exception {

        //
        // deal with evento
        Optional<Evento> eventFromReq = eventoRepository.findById(id_evento);

        if (eventFromReq.isEmpty()) {
            throw new Exception("O evento com o id " + id_evento + " não existe.");
        }

        //
        // deal with Artista
        String nameOfArtista = artistaFromReq.getNome();
        String styleOfArtista = artistaFromReq.getEstilo();
        String bioOfArtista = artistaFromReq.getBiografia();

        if (nameOfArtista == null || nameOfArtista.isEmpty()) {
            throw new Exception("'name' of artista can't be empty.");
        }

        if (styleOfArtista == null || styleOfArtista.isEmpty()) {
            throw new Exception("'style' of artista can't be empty.");
        }

        if (bioOfArtista == null || bioOfArtista.isEmpty()) {
            throw new Exception("'bio' of artista can't be empty.");
        }

        // set event and save
        artistaFromReq.setEvento(eventFromReq.get());
        return artistaRepository.save(artistaFromReq);
    }

    @Override
    public Artista editArtistaAtDB(Long id_evento, Long id_artista, Artista artistaFromReq) throws Exception {

        // check if event exists
        Optional<Evento> eventOnDB = eventoRepository.findById(id_evento);

        if (eventOnDB.isEmpty()) {
            throw new Exception("Event with ID " + id_evento + " does not exist on the DB");
        }

        // check if artist exists
        Optional<Artista> artistaOnDB = artistaRepository.findById(id_artista);

        if (artistaOnDB.isEmpty()) {
            throw new Exception("Artista with ID " + id_artista + " does not exist on the DB");
        }

        // check if event and artista match
        if (!Objects.equals(artistaOnDB.get().getEvento().getId(), id_evento)) {
            throw new Exception("Event ID and Artista ID don't match.");
        }

        // verification
        String artistaNome = artistaFromReq.getNome();
        String artistaEstilo = artistaFromReq.getEstilo();
        String artistaBio = artistaFromReq.getBiografia();
        if (artistaNome == null || artistaEstilo == null || artistaBio == null || artistaNome.isEmpty() || artistaEstilo.isEmpty() || artistaBio.isEmpty()) {
            throw new Exception("JSON format incorrect for the edit. Nome, estilo and biogarafia can't be empty.");
        }

        // update artista on DB
        Artista artistaToUpdate = artistaOnDB.get();
        BeanUtils.copyProperties(artistaFromReq, artistaToUpdate, "id", "evento");

        return artistaRepository.save(artistaToUpdate);
    }
}
