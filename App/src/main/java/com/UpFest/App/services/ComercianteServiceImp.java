package com.UpFest.App.services;

import com.UpFest.App.entities.Comerciante;
import com.UpFest.App.repositories.ComercianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComercianteServiceImp implements ComercianteService {

    @Autowired
    ComercianteRepository comercianteRepository;

    @Override
    public boolean addComerciante(Comerciante comerciante) {
        return false;
    }

    @Override
    public boolean listComerciantes() {

        return false;
    }

    @Override
    public boolean deleteComerciante(Long id_comerciante) {
        return false;
    }


}
