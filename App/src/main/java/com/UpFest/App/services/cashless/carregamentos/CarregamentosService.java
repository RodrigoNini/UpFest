package com.UpFest.App.services.cashless.carregamentos;

import com.UpFest.App.entities.CarregamentoCashlessDTO;
import com.UpFest.App.entities.ContaCashless;
import com.UpFest.App.entities.Pagamento;
import com.UpFest.App.entities.Participante;

public interface CarregamentosService {
    ContaCashless getSaldoFromParticipante (Long id_evento, String emailParticipante) throws Exception;
    ContaCashless carregarSaldo (Long id_evento, CarregamentoCashlessDTO carregamentoCashlessDTO) throws Exception;
}
