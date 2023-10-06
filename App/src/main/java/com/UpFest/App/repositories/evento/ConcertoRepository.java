package com.UpFest.App.repositories.evento;

import com.UpFest.App.entities.Concerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertoRepository extends JpaRepository<Concerto, Long> {
    List<Concerto> findByEventoId(Long id_evento);
}
