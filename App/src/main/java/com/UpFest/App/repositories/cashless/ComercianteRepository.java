package com.UpFest.App.repositories.cashless;

import com.UpFest.App.entities.Comerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long> {
    List<Comerciante> findByEventoId(Long id_evento);
}
