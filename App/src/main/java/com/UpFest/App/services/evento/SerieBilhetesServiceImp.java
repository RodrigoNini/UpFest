package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.SerieBilhetes;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.evento.SerieBilhetesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        if (numero_bilhetes < 0) {
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
}
