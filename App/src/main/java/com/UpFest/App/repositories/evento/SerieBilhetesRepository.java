package com.UpFest.App.repositories.evento;

import com.UpFest.App.entities.SerieBilhetes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieBilhetesRepository extends JpaRepository<SerieBilhetes, Long> {
    List<SerieBilhetes> findByEventoId(Long id_evento);

    // int findByNumero_bilhetes(int numero_bilhetes);
}
