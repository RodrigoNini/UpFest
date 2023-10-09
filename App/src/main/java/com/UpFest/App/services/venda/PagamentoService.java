package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Pagamento;

import java.util.List;

public interface PagamentoService {
    Pagamento validarPagamento(Long entidade, Long referencia, Long valor) throws Exception;
    List<Pagamento> getPagamentoToDB(String email) throws Exception;
}
