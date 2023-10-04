package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ContaCashless {

    @Id
    @GeneratedValue
    private Long id;
    private double valor_atual;
    @ManyToOne
    private Participante participante;
    @ManyToOne
    private Evento evento;

    protected ContaCashless(){
    }

    protected ContaCashless(Long id, double valor_atual, Participante participante,Evento evento) {
        this.id = id;
        this.valor_atual = valor_atual;
        this.participante = participante;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor_atual() {
        return valor_atual;
    }

    public void setValor_atual(double valor_atual) {
        this.valor_atual = valor_atual;
    }
}
