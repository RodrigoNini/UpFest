package com.UpFest.App.services.evento;

import com.UpFest.App.entities.SerieBilhetes;

public interface SerieBilhetesService {
    SerieBilhetes addSerieBilhetesToDB(Long id_evento, SerieBilhetes serieBilhetes) throws Exception;
}
