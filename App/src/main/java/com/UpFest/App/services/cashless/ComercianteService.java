package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.Comerciante;

import java.util.List;

public interface ComercianteService {

   Comerciante addComerciante(Long id_evento, Comerciante comerciante) throws Exception;

   Comerciante editComerciante(Long id_evento, Long id_comerciante, Comerciante comerciante) throws Exception;

   List<Comerciante> listComerciantes(Long id_evento) throws Exception;


}
