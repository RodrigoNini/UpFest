package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Palco;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.PalcoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public Palco editPalcoAtDB(Long id_evento, Long id_palco, Palco palcoFromReq) throws Exception {

        // check if event exists
        Optional<Evento> eventOnDB = eventoRepository.findById(id_evento);

        if (eventOnDB.isEmpty()) {
            throw new Exception("Event with ID " + id_evento + " does not exist on the DB");
        }

        // check if palco exists
        Optional<Palco> palcoOnDB = palcoRepository.findById(id_palco);

        if (palcoOnDB.isEmpty()) {
            throw new Exception("Palco with ID " + id_palco + " does not exist on the DB");
        }

        // check if event and palco match
        if (!Objects.equals(palcoOnDB.get().getEvento().getId(), id_evento)) {
            throw new Exception("Event ID and Palco ID don't match.");
        }

        // update palco on DB
        Palco palcoToUpdate = palcoOnDB.get();
        BeanUtils.copyProperties(palcoFromReq, palcoToUpdate, new String[]{"id", "evento"});

        return palcoRepository.save(palcoToUpdate);
    }

    @Override
    public List<Palco> getPalcosFromDB(Long id_evento) throws Exception {

        List<Palco> palcosFromDB = palcoRepository.findByEventoId(id_evento);

        if (palcosFromDB.isEmpty()) {
            throw new Exception("No palcos in the DB for this event.");
        }

        return palcosFromDB;
    }
}
