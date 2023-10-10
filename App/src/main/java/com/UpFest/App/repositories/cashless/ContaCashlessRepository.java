package com.UpFest.App.repositories.cashless;

import com.UpFest.App.entities.ContaCashless;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaCashlessRepository extends JpaRepository<ContaCashless, Long> {

    Optional<ContaCashless> findByParticipanteId(Long id_participante);

}
