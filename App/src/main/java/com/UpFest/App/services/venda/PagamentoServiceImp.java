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
        Optional<Bilhete> bilhetePago = bilheteRepository.findByPagamentoId(pagamentoOptional.get().getId());
        if (!bilhetePago.isPresent()) {
            throw new Exception("Erro: deverá ser utilizado o endpoint /cashless/validar_pagamento");
        }
        if (bilhetePago.get().getCodigo() == null) {
            bilhetePago.get().setCodigo("FOEMFOND");
            bilheteRepository.save(bilhetePago.get());
        }
        pagamentoOptional.get().setData_validado(new Date());

        return pagamentoRepository.save(pagamentoOptional.get());
    }

    @Override
    public List<Pagamento> pagamentosParticipante(String participante) throws Exception {
        List<Pagamento> pagamentosToSend = new ArrayList<>();

        // pagamento bilhete
        Optional<Participante> participanteFromReq = participanteRepository.findByEmail(participante);

        Optional<Bilhete> bilheteFromParticipante = bilheteRepository.findByParticipanteId(participanteFromReq.get().getId());

        Optional<Pagamento> pagamentoFromParticipante = pagamentoRepository.findById(bilheteFromParticipante.get().getPagamento().getId());

        pagamentosToSend.add(pagamentoFromParticipante.get());

        // pagamentos cashless

        // Optional<ContaCashless> contaCashlessFromParticipante = contaCashlessRepository.findByParticipanteId(participanteFromReq.get().getId());
        // pagamentosToSend.addAll(contaCashlessFromParticipante.get().getPagamentoCashlesses());


        return pagamentosToSend;

    }

    @Override
    public List<Pagamento> getPagamentoToDB(String email) throws Exception {

//        Pagamento pagamento = pagamentoRepository.findById(pagamento).get();
//        List<Pagamento> pagamentoFromDB = pagamentoRepository.findByPagamento(pagamento);
//        if (pagamentoFromDB.isEmpty()) {
//            throw new Exception("Participante não está no evento.");
//        }
        //Optional<Pagamento> participantePagamento = pagamentoRepository.findByData(data_validado);


        return null;
//        pagamentoFromDB;
    }


}
