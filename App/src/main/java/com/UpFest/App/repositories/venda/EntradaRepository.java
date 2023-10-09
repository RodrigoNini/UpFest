package com.UpFest.App.repositories.venda;

import com.UpFest.App.entities.Bilhete;
import com.UpFest.App.entities.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Long> {
    Optional<Bilhete> findByBilhete(Bilhete bilhete);
}
