package com.UpFest.App.controllers.venda;

import com.UpFest.App.entities.*;
import com.UpFest.App.services.venda.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        System.out.println(bilheteDTO);

        try {
            Bilhete bilhete = bilheteService.comprarBilhete(bilheteDTO.getEvento(), bilheteDTO.getNome(), bilheteDTO.getEmail(), bilheteDTO.getSerie());
            return ResponseEntity.ok("O bilhete para o evento '" + bilhete.getEvento().getId() + "' teve sua compra adicionada à BD com o ID bilhete: " + bilhete.getId() + ".");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/bilhetes/validar_entrada")
    public ResponseEntity<?> validarBilhete(@RequestBody Map<String, Object> requestBody) {

        // Obter valores do corpo da requisição
        Long id_evento = Long.parseLong(requestBody.get("id_evento").toString());
        String codigo = requestBody.get("codigo").toString();

        try {
            Bilhete bilhete = bilheteService.validarBilhete(id_evento, codigo);
            return ResponseEntity.ok("O bilhete para o evento '" + bilhete.getEvento() + "' teve seu registo de entrada efetuado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

@GetMapping("/participantes/listar")
public ResponseEntity<?> listarParticipante(@RequestParam Long id_evento) {
    return null;
}


}
