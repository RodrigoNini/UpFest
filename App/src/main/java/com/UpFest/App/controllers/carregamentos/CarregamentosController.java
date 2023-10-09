package com.UpFest.App.controllers.carregamentos;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/cashless")
public class CarregamentosController {

    @GetMapping("/{id_evento}/saldo")
    public ResponseEntity<?> getSaldoFromParticipante(@PathVariable Long id_evento, @RequestParam String participante) {

        return null;
    }
}
