package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.Comerciante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ComercianteService {

    Comerciante addComerciante(Long id_evento, Comerciante comerciante);
    Comerciante editComerciante(Long id_evento, Long id_comerciante, Comerciante comerciante) throws Exception;
    List<Comerciante> listComerciantes(Long id_evento);
    Comerciante registarCompra(@PathVariable Long id_evento);


}
