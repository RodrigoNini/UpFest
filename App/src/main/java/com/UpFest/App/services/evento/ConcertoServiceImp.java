package com.UpFest.App.services.evento;

import com.UpFest.App.entities.*;
import com.UpFest.App.repositories.evento.ArtistaRepository;
import com.UpFest.App.repositories.evento.ConcertoRepository;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.PalcoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

        if (!Objects.equals(artistaFromDTO.get().getEvento().getId(), id_evento)) {
            throw new Exception("O artista com o ID " + concertoDTO.getArtista() + " não existe no evento com ID " + id_evento);
        }

        //
        // deal with palco
        //
        Optional<Palco> palcoFromDTO = palcoRepository.findById(concertoDTO.getPalco());

        if (!palcoFromDTO.isPresent()) {
            throw new Exception("O palco com o id " + concertoDTO.getArtista() + " não existe.");
        }

        if (!Objects.equals(palcoFromDTO.get().getEvento().getId(), id_evento)) {
            throw new Exception("O palco com o ID " + concertoDTO.getPalco() + " não existe no evento com ID " + id_evento);
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

    @Override
    public Concerto editConcertoAtDB(Long id_evento, Long id_concerto, ConcertoDTO concertoDTO) throws Exception {

        //
        // deal with evento
        //
        Optional<Evento> eventFromReq = eventoRepository.findById(id_evento);

        if (!eventFromReq.isPresent()) {
            throw new Exception("O evento com o id " + id_evento + " não existe.");
        }

        //
        // check if concerto exists
        //
        Optional<Concerto> concertoOnDB = concertoRepository.findById(id_concerto);

        if (!concertoOnDB.isPresent()) {
            throw new Exception("O concerto com o id " + id_concerto + " não existe.");
        }

        //
        // check if event and concerto match
        //
        if (!Objects.equals(concertoOnDB.get().getEvento().getId(), id_evento)) {
            throw new Exception("Event ID and Palco ID don't match.");
        }

        //
        //
        //  SECOND STAGE 🔽
        //
        //

        //
        // deal with artist
        //
        Optional<Artista> artistaFromDTO = artistaRepository.findById(concertoDTO.getArtista());

        if (!artistaFromDTO.isPresent()) {
            throw new Exception("O artista com o id " + concertoDTO.getArtista() + " não existe.");
        }

        if (!Objects.equals(artistaFromDTO.get().getEvento().getId(), id_evento)) {
            throw new Exception("O artista com o ID " + concertoDTO.getArtista() + " não existe no evento com ID " + id_evento);
        }

        //
        // deal with palco
        //
        Optional<Palco> palcoFromDTO = palcoRepository.findById(concertoDTO.getPalco());

        if (!palcoFromDTO.isPresent()) {
            throw new Exception("O palco com o id " + concertoDTO.getArtista() + " não existe.");
        }

        if (!Objects.equals(palcoFromDTO.get().getEvento().getId(), id_evento)) {
            throw new Exception("O palco com o ID " + concertoDTO.getPalco() + " não existe no evento com ID " + id_evento);
        }

        //
        // save
        //
        Concerto concertoToUpdate = concertoOnDB.get();

        concertoToUpdate.setArtista(artistaFromDTO.get());
        concertoToUpdate.setPalco(palcoFromDTO.get());
        concertoToUpdate.setDataHoraInicio(concertoDTO.getData_hora_inicio());
        concertoToUpdate.setDataHoraFim(concertoDTO.getData_hora_fim());

        return concertoRepository.save(concertoToUpdate);
    }

    @Override
    public List<ConcertoDTOResponse> getConcertosFromDB(Long id_evento) throws Exception {

        List<Concerto> concertosFromDB = concertoRepository.findByEventoId(id_evento);
        List<ConcertoDTOResponse> concertoDTOSToSend = new ArrayList<>();

        if (concertosFromDB.isEmpty()) {
            throw new Exception("No Concertos in the DB for this event.");
        }

        for (Concerto concerto : concertosFromDB) {
            concertoDTOSToSend.add(new ConcertoDTOResponse(concerto.getId(), concerto.getArtista().getId(), concerto.getPalco().getId(), concerto.getDataHoraInicio(), concerto.getDataHoraFim()));
        }

        return concertoDTOSToSend;
    }


}
