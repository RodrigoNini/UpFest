package com.UpFest.App.repositories;


import com.UpFest.App.entities.ProdutoComerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoComercianteRepository extends JpaRepository<ProdutoComerciante, Long> {

}
