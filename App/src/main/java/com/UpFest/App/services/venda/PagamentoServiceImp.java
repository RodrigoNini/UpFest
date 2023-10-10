package com.UpFest.App.services.venda;

import com.UpFest.App.entities.*;
import com.UpFest.App.repositories.cashless.ContaCashlessRepository;
import com.UpFest.App.repositories.venda.BilheteRepository;
import com.UpFest.App.repositories.venda.PagamentoRepository;
import com.UpFest.App.repositories.venda.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImp implements PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;
    @Autowired
    BilheteRepository bilheteRepository;
    @Autowired
    ParticipanteRepository participanteRepository;
    @Autowired
    ContaCashlessRepository contaCashlessRepository;

    @Override
    public Pagamento validarPagamento(int entidade, int referencia, double valor) throws Exception {
        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findByEntidadeAndReferenciaAndValor(entidade, referencia, valor);
        if (!pagamentoOptional.isPresent()) {
            throw new Exception("Pagamento não encontrado ou não existe.");
        }
        if (pagamentoOptional.get().getData_validado() != null) {
            throw new Exception("Pagamento já validado.");
        }
        Bilhete bilhetePago = pagamentoOptional.get().getBilhete();
        if (bilhetePago.getCodigo() == null) {
            bilhetePago.setCodigo("FOEMFOND");
            bilheteRepository.save(bilhetePago);
        }
        pagamentoOptional.get().setData_validado(new Date());

        return pagamentoRepository.save(pagamentoOptional.get());
    }

    @Override
    public List<Pagamento> pagamentosParticipante(String email) throws Exception {
        return pagamentoRepository.findByBilheteParticipanteEmail(email);

    }

    @Override
    public List<Pagamento> getPagamentoToDB(String email) throws Exception {

        List<Pagamento> pagamento = pagamentoRepository.findByBilheteParticipanteEmail(email);
         //pagamentoFromDB = pagamentoRepository.findByPagamento(pagamento);
        if (pagamento.isEmpty()) {
            throw new Exception("Pagamento.");
        }

        return pagamento;
    }


}
