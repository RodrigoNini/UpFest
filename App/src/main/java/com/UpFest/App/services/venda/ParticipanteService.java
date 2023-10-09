package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Participante;

import java.util.List;

public interface ParticipanteService {
    List<Participante> getParticipanteToDB(Long id_evento) throws Exception;
}
