package com.UpFest.App.services.venda;

import com.UpFest.App.entities.Bilhete;
import com.UpFest.App.entities.Pagamento;
import com.UpFest.App.repositories.venda.BilheteRepository;
import com.UpFest.App.repositories.venda.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImp implements PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;
    @Autowired
    BilheteRepository bilheteRepository;
    @Override
    public Pagamento validarPagamento(int entidade, int referencia, double valor) throws Exception {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findByEntidadeAndReferenciaAndValor(entidade, referencia, valor);
        if (!pagamentoOptional.isPresent()) {
            throw new Exception("Pagamento não encontrado ou não existe.");
        }
        if (pagamentoOptional.get().getData_validado() != null) {
            throw new Exception("Pagamento já validado.");
        }
        Optional<Bilhete> bilhetePago = bilheteRepository.findByPagamentoId(pagamentoOptional.get().getId());
        if (!bilhetePago.isPresent()) {
            throw new Exception("Erro: deverá ser utilizado o endpoint /cashless/validar_pagamento");
        }
        if (bilhetePago.get().getCodigo()==null) {
            bilhetePago.get().setCodigo("FOEMFOND");
            bilheteRepository.save(bilhetePago.get());
        }
        pagamentoOptional.get().setData_validado(new Date());

        return pagamentoRepository.save(pagamentoOptional.get());
    }

    @Override
    public List<Pagamento> getPagamentoToDB(String email) throws Exception {
        return null;
    }
//        LISTAR
//      "Lista todos os pagamentos associados a um participante, indicando o respetivo estado (pendentes ou pagos). Será útil para o participante confirmar se tem algum pagamento por finalizar."

//        VALIDAR PAGAMENTO
//      "Endpoint chamado para validar pagamentos de compra de bilhete ou pagamentos de carregamento cashless.
//      Quando este endpoint é chamado:
//      1. Verificar se o pagamento existe (referência, entidade e valor);
//      2. Verificar se o pagamento ainda não foi validado;
//      3. Verificar se é um pagamento de bilhete (verificar se está na tabela de bilhete) ou cashless (verificar a tabela pagamento_cashless);
//      4. Se for um pagamento de bilhete, verificar se o bilhete já tem código. Caso contrário, gerar código aleatório do bilhete para ser usado na validação de entrada;
//      5. Se for um carregamento cashless retornar um erro a avisar que deverá ser utilizado o endpoint /cashless/validar_pagamento"
}
