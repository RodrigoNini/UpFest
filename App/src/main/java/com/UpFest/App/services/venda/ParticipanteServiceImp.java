package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Participante;
import com.UpFest.App.repositories.venda.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteServiceImp implements ParticipanteService{

    @Autowired
    ParticipanteRepository participanteRepository;

    @Override
    public List<Participante> getParticipanteToDB(Long id_evento) throws Exception {
        return null;
    }
//    "Lista os participantes inscritos no evento que fizeram o pagamento, e se já deram entrada no evento ou não."
}
