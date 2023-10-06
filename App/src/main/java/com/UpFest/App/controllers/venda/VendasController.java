package com.UpFest.App.controllers.venda;

import com.UpFest.App.services.venda.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class VendasController {

    @Autowired
    private BilheteService bilheteService;

    @Autowired
    private ParticipanteService participanteService;

    @Autowired
    private PagamentoService pagamentoService;


}
