package com.UpFest.App.services.evento;

import com.UpFest.App.entities.Palco;

import java.util.List;

public interface PalcoService {
    Palco addPalcoToDB(Long id_evento, Palco palco) throws Exception;

    Palco editPalcoAtDB(Long id_evento, Long id_palco, Palco palco) throws Exception;

    List<Palco> getPalcosFromDB(Long id_evento) throws Exception;
}
