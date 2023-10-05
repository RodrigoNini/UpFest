package com.UpFest.App.services;

import com.UpFest.App.entities.Comerciante;

import java.util.List;

public interface ComercianteService {

    boolean addComerciante(Comerciante comerciante);

    boolean listComerciantes();

    boolean deleteComerciante(Long id_comerciante);


}
