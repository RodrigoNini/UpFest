package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Artista;
import com.UpFest.App.entities.Evento;
import com.UpFest.App.repositories.evento.ArtistaRepository;
import com.UpFest.App.repositories.evento.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (!eventFromReq.isPresent()) {
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
}
