package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Palco;

public interface PalcoService {
    Palco addPalcoToDB(Long id_evento,Palco palco) throws Exception;
}
