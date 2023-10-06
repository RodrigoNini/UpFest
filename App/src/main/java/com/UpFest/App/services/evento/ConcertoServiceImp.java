package com.UpFest.App.services.evento;

import com.UpFest.App.entities.*;
import com.UpFest.App.repositories.evento.ArtistaRepository;
import com.UpFest.App.repositories.evento.ConcertoRepository;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.PalcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class ConcertoServiceImp implements ConcertoService {

    @Autowired
    ConcertoRepository concertoRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ArtistaRepository artistaRepository;

    @Autowired
    PalcoRepository palcoRepository;

    @Override
    public Concerto addConcertoToDB(Long id_evento, ConcertoDTO concertoDTO) throws Exception {
        // TODO
        // check date (imports diferentes entre o concerto e concertoDTO)

        //
        // deal with evento
        //
        Optional<Evento> eventFromReq = eventoRepository.findById(id_evento);

        if (!eventFromReq.isPresent()) {
            throw new Exception("O evento com o id " + id_evento + " não existe.");
        }

        //
        // deal with artist
        //
        Optional<Artista> artistaFromDTO = artistaRepository.findById(concertoDTO.getArtista());

        if (!artistaFromDTO.isPresent()) {
            throw new Exception("O artista com o id " + concertoDTO.getArtista() + " não existe.");
        }

        //
        // deal with palco
        //
        Optional<Palco> palcoFromDTO = palcoRepository.findById(concertoDTO.getPalco());

        if (!palcoFromDTO.isPresent()) {
            throw new Exception("O palco com o id " + concertoDTO.getArtista() + " não existe.");
        }

        //
        // create concerto
        //
        Concerto concertoToSave = new Concerto(concertoDTO.getData_hora_inicio(), concertoDTO.getData_hora_fim());

        // set evento, artista and palco
        concertoToSave.setArtista(artistaFromDTO.get());
        concertoToSave.setPalco(palcoFromDTO.get());
        concertoToSave.setEvento(eventFromReq.get());

        //save
        return concertoRepository.save(concertoToSave);
    }
}
