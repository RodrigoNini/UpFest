package com.UpFest.App.repositories;

import com.UpFest.App.entities.Comerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long> {
}
