package com.UpFest.App.repositories.evento;

import com.UpFest.App.entities.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    List<Artista> findByEventoId(Long id_evento);
}
