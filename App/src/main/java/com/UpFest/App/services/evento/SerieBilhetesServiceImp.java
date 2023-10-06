package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Palco;
import com.UpFest.App.entities.SerieBilhetes;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.SerieBilhetesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class SerieBilhetesServiceImp implements SerieBilhetesService {

    @Autowired
    SerieBilhetesRepository serieBilhetesRepository;

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public SerieBilhetes addSerieBilhetesToDB(Long id_evento, SerieBilhetes serieBilhetesFromReq) throws Exception {

        //
        // deal with evento
        Optional<Evento> eventFromReq = eventoRepository.findById(id_evento);

        if (!eventFromReq.isPresent()) {
            throw new Exception("O evento com o id " + id_evento + " não existe.");
        }

        //
        // deal with serieBilhetes
        String designacao = serieBilhetesFromReq.getDesignacao();
        int numero_bilhetes = serieBilhetesFromReq.getNumero_bilhetes();
        Date limite_vendas = serieBilhetesFromReq.getLimite_vendas();
        double custo = serieBilhetesFromReq.getCusto();

        if (designacao == null || designacao.isEmpty()) {
            throw new Exception("'designacao' of SerieBilhetes can't be empty.");
        }

        if (numero_bilhetes <= 0) {
            throw new Exception("'numero_bilhetes' of SerieBilhetes can't less than 0.");
        }

        if (limite_vendas == null) {
            throw new Exception("'limite_vendas' of SerieBilhetes can't be empty.");
        }

        if (custo < 0) {
            throw new Exception("'custo' of SerieBilhetes can't be less than 0.");
        }

        // set event and save
        serieBilhetesFromReq.setEvento(eventFromReq.get());
        return serieBilhetesRepository.save(serieBilhetesFromReq);

    }

    @Override
    public SerieBilhetes editSerieBilhetesAtDB(Long id_evento, Long id_serie, SerieBilhetes serieBilhetesFromReq) throws Exception {
        // TODO
        // o json deixa pssar sem a menção do numero de bilhetes (bilhetes = 0)
        //

        // check if event exists
        Optional<Evento> eventOnDB = eventoRepository.findById(id_evento);

        if (eventOnDB.isEmpty()) {
            throw new Exception("Event with ID " + id_evento + " does not exist on the DB");
        }

        // check if SerieBilhetes exists
        Optional<SerieBilhetes> serieBilhetesOnDB = serieBilhetesRepository.findById(id_serie);

        if (serieBilhetesOnDB.isEmpty()) {
            throw new Exception("SerieBilhetes with ID " + id_evento + " does not exist on the DB");
        }

        // check if event and SerieBilhetes match
        if (!Objects.equals(serieBilhetesOnDB.get().getEvento().getId(), id_evento)) {
            throw new Exception("Event ID and SerieBilhetes ID don't match.");
        }

        if (serieBilhetesFromReq.getDesignacao() == null || serieBilhetesFromReq.getDesignacao().isEmpty() || serieBilhetesFromReq.getNumero_bilhetes() < 0 || serieBilhetesFromReq.getCusto() <= 0 || serieBilhetesFromReq.getLimite_vendas() == null) {
            throw new Exception("JSON format incorrect for the edit.");
        }

        // update SerieBilhetes on DB
        SerieBilhetes serieBilhetesToUpdate = serieBilhetesOnDB.get();
        BeanUtils.copyProperties(serieBilhetesFromReq, serieBilhetesToUpdate, new String[]{"id", "evento"});

        return serieBilhetesRepository.save(serieBilhetesToUpdate);
    }
}
