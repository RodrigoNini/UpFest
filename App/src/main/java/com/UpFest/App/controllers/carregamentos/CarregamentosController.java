package com.UpFest.App.controllers.carregamentos;

import com.UpFest.App.entities.CarregamentoCashlessDTO;
import com.UpFest.App.entities.ContaCashless;
import com.UpFest.App.entities.MovimentoCashless;
import com.UpFest.App.entities.Participante;
import com.UpFest.App.services.cashless.carregamentos.CarregamentosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/cashless")
public class CarregamentosController {

    @Autowired
    CarregamentosServiceImp carregamentosServiceImp;

    @GetMapping("/{id_evento}/saldo")
    public ResponseEntity<?> getSaldoFromParticipante(@PathVariable Long id_evento, @RequestParam String participante) {

        try {
            ContaCashless contaCashless = carregamentosServiceImp.getSaldoFromParticipante(id_evento, participante);
            return ResponseEntity.status(HttpStatus.OK).body(contaCashless.getValor_atual() + " euros.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping("/{id_evento}/extrato")
    public ResponseEntity<?> getExtratoFromUser(@PathVariable Long id_evento, @RequestParam String participante) {

        try {
            ///List<MovimentoCashless> movimentoCashless = carregamentosServiceImp.
            return null;
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/{id_evento}/carregar")
    public ResponseEntity<?> carregarToUser (@PathVariable Long id_evento, @RequestBody CarregamentoCashlessDTO carregamentoCashlessDTO) {
        try {
            ContaCashless contaCashless = carregamentosServiceImp.carregarSaldo(id_evento, carregamentoCashlessDTO);
            return ResponseEntity.status(HttpStatus.OK).body(contaCashless.getValor_atual() + " euros.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
