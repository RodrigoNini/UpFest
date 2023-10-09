package com.UpFest.App.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ContaCashless {

    @Id
    @GeneratedValue
    private Long id;
    private double valor_atual;

    @OneToMany(mappedBy = "contaCashless")
    private List<MovimentoCashless> movimentoCashlesses;
    @OneToMany(mappedBy = "contaCashless")
    private List<PagamentoCashless> pagamentoCashlesses;
    @ManyToOne
    private Participante participante;
    @ManyToOne
    private Evento evento;

    protected ContaCashless() {
    }

    public ContaCashless(double valor_atual, Participante participante, Evento evento) {
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
