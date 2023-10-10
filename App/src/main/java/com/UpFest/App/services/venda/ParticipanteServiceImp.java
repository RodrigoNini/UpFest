package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Bilhete;
import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Pagamento;
import com.UpFest.App.entities.Participante;
import com.UpFest.App.repositories.evento.EventoRepository;
import com.UpFest.App.repositories.venda.BilheteRepository;
import com.UpFest.App.repositories.venda.PagamentoRepository;
import com.UpFest.App.repositories.venda.ParticipanteRepository;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.server.ExportException;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipanteServiceImp implements ParticipanteService{

    @Autowired
    ParticipanteRepository participanteRepository;
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    PagamentoRepository pagamentoRepository;
    @Autowired
    BilheteRepository bilheteRepository;

    @Override
    public List<Participante> getParticipanteToDB(Long id_evento) throws Exception {

        Evento evento = eventoRepository.findById(id_evento).get();
        List<Participante> participanteFromDB = participanteRepository.findByBilheteEvento(evento);
        if (participanteFromDB.isEmpty()) {
            throw new Exception("Participante não está no evento.");
        }
        //Optional<Pagamento> participantePagamento = pagamentoRepository.findByData(data_validado);


        return participanteFromDB;
//        participanteFromDB;
    }


//    "Lista os participantes inscritos no evento que fizeram o pagamento, e se já deram entrada no evento ou não."
}
