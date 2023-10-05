package com.UpFest.App.repositories.evento;

import com.UpFest.App.entities.Palco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalcoRepository extends JpaRepository<Palco, Long> {
}
