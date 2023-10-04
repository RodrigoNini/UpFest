package com.UpFest.App.controllers;

import com.UpFest.App.entities.ProdutoComerciante;
import com.UpFest.App.services.CashlessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/cashless")
public class CashlessController {

    @Autowired
    private CashlessService cashlessService;

    @PostMapping("{id_evento}/comerciantes/{id_comerciante}/produtos/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@PathVariable Long id_evento, @PathVariable Long id_comerciante, @RequestBody ProdutoComerciante produtoComerciante){
        cashlessService.addItem(produtoComerciante);
    }


}
