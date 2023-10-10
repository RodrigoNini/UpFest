package com.UpFest.App.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ContaCashless {

    @Id
    @GeneratedValue
    private Long id;
    private double valor_atual;

    @OneToMany(mappedBy = "contaCashless")
    @JsonIgnore
    private List<MovimentoCashless> movimentoCashlesses;
    @OneToMany(mappedBy = "contaCashless")
    @JsonIgnore
    private List<PagamentoCashless> pagamentoCashlesses;
    @ManyToOne
    @JsonIgnore
    private Participante participante;
    @ManyToOne
    @JsonIgnore
    private Evento evento;

    protected ContaCashless() {
    }

    public ContaCashless(double valor_atual) {
        this.valor_atual = valor_atual;
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

    public List<MovimentoCashless> getMovimentoCashlesses() {
        return movimentoCashlesses;
    }

    public void setMovimentoCashlesses(List<MovimentoCashless> movimentoCashlesses) {
        this.movimentoCashlesses = movimentoCashlesses;
    }

    public List<PagamentoCashless> getPagamentoCashlesses() {
        return pagamentoCashlesses;
    }

    public void setPagamentoCashlesses(List<PagamentoCashless> pagamentoCashlesses) {
        this.pagamentoCashlesses = pagamentoCashlesses;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
