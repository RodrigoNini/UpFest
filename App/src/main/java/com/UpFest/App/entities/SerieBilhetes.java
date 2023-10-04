package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class SerieBilhetes {

    @Id
    @GeneratedValue
    private Long id;
    private String designacao;
    private int numero_bilhetes;
    private Date limite_vendas;
    private double custo;
    @ManyToOne
    private Evento evento;

    protected SerieBilhetes(){
    }

    public SerieBilhetes(Long id, String designacao, int numero_bilhetes, Date limite_vendas, double custo) {
        this.id = id;
        this.designacao = designacao;
        this.numero_bilhetes = numero_bilhetes;
        this.limite_vendas = limite_vendas;
        this.custo = custo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public int getNumero_bilhetes() {
        return numero_bilhetes;
    }

    public void setNumero_bilhetes(int numero_bilhetes) {
        this.numero_bilhetes = numero_bilhetes;
    }

    public Date getLimite_vendas() {
        return limite_vendas;
    }

    public void setLimite_vendas(Date limite_vendas) {
        this.limite_vendas = limite_vendas;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
