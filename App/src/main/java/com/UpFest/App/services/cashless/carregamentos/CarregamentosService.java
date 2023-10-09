package com.UpFest.App.services.cashless.carregamentos;

import com.UpFest.App.entities.ContaCashless;

public interface CarregamentosService {
    ContaCashless getSaldoFromParticipante (Long id_evento, String emailParticipante) throws Exception;
}
