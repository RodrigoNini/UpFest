package com.UpFest.App.controllers.venda;

import com.UpFest.App.entities.*;
import com.UpFest.App.services.venda.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    private BilheteService bilheteService;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/bilhetes/comprar")
    public ResponseEntity<?> comprarBilhete(@RequestBody BilheteDTO bilheteDTO) {

        try {
            Bilhete bilhete = bilheteService.comprarBilhete(bilheteDTO.getEvento(), bilheteDTO.getNome(), bilheteDTO.getEmail(), bilheteDTO.getSerie());
            return ResponseEntity.ok("O bilhete para o evento '" + bilhete.getEvento().getId() + "' teve sua compra adicionada à BD com o ID bilhete: " + bilhete.getId() + ".");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/bilhetes/validar_entrada")
    public ResponseEntity<?> validarBilhete(@RequestBody ValidarDTO validarDTO) {

        try {
            Bilhete bilhete = bilheteService.validarBilhete(validarDTO.getEvento(), validarDTO.getCodigo());
            return ResponseEntity.ok("O bilhete para o evento '" + bilhete.getEvento().getDesignacao() + "' teve seu registo de entrada efetuado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/pagamentos/validar")
    public ResponseEntity<?> validarPagamento(@RequestBody Pagamento pagamento) {
        int pagamentoEntidade = pagamento.getEntidade();
        int pagamentoReferencia = pagamento.getReferencia();
        double pagamentoValor = pagamento.getValor();

        try {
            Pagamento pagamentoValidado = pagamentoService.validarPagamento(pagamentoEntidade, pagamentoReferencia, pagamentoValor);
            return ResponseEntity.ok("Pagamento validado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/participantes/listar")
    public List<Participante> listarParticipante(@RequestParam Long evento) {
        try {
            return participanteService.getParticipanteToDB(evento);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/pagamentos/listar")
    public List<Pagamento> listarPagamentosParticipante(@RequestParam String participante) {

        try {
            return pagamentoService.getPagamentoToDB(participante);
//             List<Pagamento> pagamentosParticipante = pagamentoService.pagamentosParticipante(participante);
//            return ResponseEntity.ok(pagamentosParticipante);
        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            return null;
        }

    }


}
