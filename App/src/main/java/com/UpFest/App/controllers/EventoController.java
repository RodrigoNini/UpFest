package com.UpFest.App.controllers;

import com.UpFest.App.entities.Evento;
import com.UpFest.App.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoService eventoService;


    @PostMapping("/criar")
    public void addEventoToDB(@RequestBody Evento evento){
        eventoService.addEventoToDB(evento);
    }

}
