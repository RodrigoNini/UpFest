package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Bilhete;
import com.UpFest.App.entities.Participante;

import java.util.Date;
import java.util.List;

public interface BilheteService {
    Bilhete comprarBilhete(Long id_evento, String nome, String email, Long id_serieBilhetes) throws Exception;
    Bilhete validarBilhete(Long id_evento, String codigo) throws Exception;

    List<Participante> listarParticipante(Long id_evento) throws Exception;

}
