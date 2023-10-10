package com.UpFest.App.repositories.venda;


import com.UpFest.App.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    Optional<Pagamento> findByEntidadeAndReferenciaAndValor(int entidade, int referencia, double valor);

    List<Pagamento> findByBilheteParticipanteEmail(String email);
}
