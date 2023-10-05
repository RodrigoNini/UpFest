package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Palco;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.PalcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalcoServiceImp implements PalcoService {

    @Autowired
    PalcoRepository palcoRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Palco addPalcoToDB(Long id_evento, Palco palco) throws Exception {

        //
        // deal with evento
        Optional<Evento> eventFromReq = eventoRepository.findById(id_evento);

        if (!eventFromReq.isPresent()) {
            throw new Exception("O evento com o id " + id_evento + " não existe.");
        }

        //
        // deal with palco
        String nameOfPalco = palco.getDesignacao();

        if (nameOfPalco == null || nameOfPalco.isEmpty()) {
            throw new Exception("'designacao' of palco can't be empty.");
        }

        // set event and save
        palco.setEvento(eventFromReq.get());
        return palcoRepository.save(palco);
    }
}
