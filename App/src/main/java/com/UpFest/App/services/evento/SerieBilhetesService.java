package com.UpFest.App.services.evento;

import com.UpFest.App.entities.SerieBilhetes;

import java.util.List;

public interface SerieBilhetesService {
    SerieBilhetes addSerieBilhetesToDB(Long id_evento, SerieBilhetes serieBilhetes) throws Exception;

    SerieBilhetes editSerieBilhetesAtDB(Long id_evento, Long id_serie, SerieBilhetes serieBilhetes) throws Exception;

    List<SerieBilhetes> getSerieBilhetesFromDB(Long id_evento) throws Exception;
}
