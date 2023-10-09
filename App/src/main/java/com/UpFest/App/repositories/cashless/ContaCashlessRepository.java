package com.UpFest.App.repositories.cashless;

import com.UpFest.App.entities.ContaCashless;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaCashlessRepository extends JpaRepository<ContaCashless, Long> {

    ContaCashless findByParticipanteId(Long id_participante);

}
