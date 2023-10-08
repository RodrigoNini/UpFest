package com.UpFest.App.repositories.venda;

import com.UpFest.App.entities.Participante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
    Optional<Participante> findByEmail(String email);
}
