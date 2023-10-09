package com.UpFest.App.services.cashless.carregamentos;

import com.UpFest.App.entities.ContaCashless;
import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Participante;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.venda.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarregamentosServiceImp implements CarregamentosService {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    ParticipanteRepository participanteRepository;

    @Override
    public ContaCashless getSaldoFromParticipante(Long id_evento, String emailParticipante) throws Exception {

        //
        // deal with evento
        Optional<Evento> eventFromReq = eventoRepository.findById(id_evento);

        if (!eventFromReq.isPresent()) {
            throw new Exception("O evento com o id " + id_evento + " não existe.");
        }

        //
        // deal with participante
        Optional<Participante> participanteFromReq = participanteRepository.findByEmail(emailParticipante);

        if (!eventFromReq.isPresent()) {
            throw new Exception("O participante com o email " + emailParticipante + " não existe.");
        }



        return null;

    }
}
