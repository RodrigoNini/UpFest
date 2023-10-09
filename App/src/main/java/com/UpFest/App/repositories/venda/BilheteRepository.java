package com.UpFest.App.repositories.venda;

import com.UpFest.App.entities.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BilheteRepository extends JpaRepository<Bilhete, Long> {

    Optional<Bilhete> findByCodigo(String codigo);
}
