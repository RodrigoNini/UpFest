package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Concerto;
import com.UpFest.App.entities.ConcertoDTO;

public interface ConcertoService {

    Concerto addConcertoToDB(Long id_evento, ConcertoDTO concertoDTO) throws Exception;
    Concerto editConcertoAtDB(Long id_evento, Long id_concerto, ConcertoDTO concertoDTO) throws Exception;
}
