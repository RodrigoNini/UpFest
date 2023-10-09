package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Bilhete;

public interface BilheteService {
    Bilhete comprarBilhete(Long id_evento, String nome, String email, Long id_serieBilhetes) throws Exception;
    Bilhete validarBilhete(Long id_evento, String codigo) throws Exception;

}
