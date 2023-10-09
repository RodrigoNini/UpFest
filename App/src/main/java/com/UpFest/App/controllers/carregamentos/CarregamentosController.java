package com.UpFest.App.controllers.carregamentos;

import com.UpFest.App.entities.ContaCashless;
import com.UpFest.App.services.cashless.carregamentos.CarregamentosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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
}
