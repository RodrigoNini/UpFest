package com.UpFest.App.repositories.evento;

import com.UpFest.App.entities.Concerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcertoRepository extends JpaRepository<Concerto, Long> {

}
