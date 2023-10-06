package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.Comerciante;
import com.UpFest.App.entities.Evento;
import com.UpFest.App.repositories.cashless.ComercianteRepository;
import com.UpFest.App.repositories.evento.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComercianteServiceImp implements ComercianteService {

    @Autowired
    ComercianteRepository comercianteRepository;
    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Comerciante addComerciante(Long id_evento, Comerciante comerciante) {

            Optional<Evento> eventoOnDB = eventoRepository.findById(id_evento);

            if(!eventoOnDB.isPresent()){
                return null;
            }

            comerciante.setEvento(eventoOnDB.get());

            return comercianteRepository.save(comerciante);
    }

    @Override
    public Comerciante editComerciante(Long id_evento, Long id_comerciante, Comerciante comerciante) throws Exception {

            Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);

            if(!comercianteOnDB.isPresent()){
                throw new Exception("Comerciante com o ID " + id_comerciante + " não existe.");
            }

            if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
                throw new Exception("O evento com o ID " + id_evento + " não existe.");
            }

            comerciante.setId(id_comerciante);
            comerciante.setEvento(comercianteOnDB.get().getEvento());

            return comercianteRepository.save(comerciante);
    }


    @Override
    public List<Comerciante> listComerciantes(Long id_evento){

        List<Comerciante> comerciantes = comercianteRepository.findAll();
        return comerciantes;
    }


}
