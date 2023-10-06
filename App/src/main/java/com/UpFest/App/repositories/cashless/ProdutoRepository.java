package com.UpFest.App.repositories.cashless;


import com.UpFest.App.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByComercianteId(Long id_comerciante);
}
