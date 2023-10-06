package com.UpFest.App.controllers;

import com.UpFest.App.entities.Comerciante;
import com.UpFest.App.services.cashless.ComercianteServiceImp;

import com.UpFest.App.services.cashless.ProdutoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/cashless")
public class CashlessController {

    @Autowired
    private ProdutoServiceImp produtoComercianteService;
    @Autowired
    private ComercianteServiceImp comercianteService;


    @PostMapping("{id_evento}/comerciantes/criar")
    public void addComerciante(@PathVariable Long id_evento, @RequestBody com.UpFest.App.entities.Comerciante comerciante){
        comercianteService.addComerciante(id_evento, comerciante);
    }





    @GetMapping("/{id_evento}/comerciantes/listar")
    public ResponseEntity<?> getComerciantes(@PathVariable Long id_evento) {

        try {
            List<Comerciante> comerciantes = comercianteService.listComerciantes(id_evento);
            return ResponseEntity.status(HttpStatus.OK).body(comerciantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
