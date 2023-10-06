package com.UpFest.App.repositories.cashless;


import com.UpFest.App.entities.ProdutoComerciante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoComerciante, Long> {
    List<ProdutoComerciante> findByComercianteId(Long id_comerciante);
}
