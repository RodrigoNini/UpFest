package com.UpFest.App.controllers.venda;

import com.UpFest.App.entities.Artista;
import com.UpFest.App.entities.Bilhete;
import com.UpFest.App.entities.SerieBilhetes;
import com.UpFest.App.services.venda.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> comprarBilhete(@RequestBody Map<String, Object> requestBody) {


        System.out.println("teste:" + requestBody);


        // Obter os valores do corpo da requisição
        Long id_evento = Long.parseLong(requestBody.get("id_evento").toString());
        String nome = requestBody.get("nome").toString();
        String email = requestBody.get("email").toString();
        Long id_serieBilhetes = Long.parseLong(requestBody.get("id_serieBilhetes").toString());

        try {
            Bilhete bilhete = bilheteService.comprarBilhete(id_evento, nome, email, id_serieBilhetes);
            return ResponseEntity.ok("O bilhete para o evento '" + bilhete.getEvento() + "' teve sua compra adicionada à BD com o ID bilhete: " + bilhete.getId() + ".");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
