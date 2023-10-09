package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Pagamento;

import java.util.List;

public interface PagamentoService {
    Pagamento validarPagamento(int entidade, int referencia, double valor) throws Exception;
    List<Pagamento> getPagamentoToDB(String email) throws Exception;
}
