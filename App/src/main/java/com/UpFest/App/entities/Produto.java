package com.UpFest.App.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long id;
    private String designacao;
    private double valor;
    @ManyToOne
    private Comerciante comerciante;
    @OneToMany(mappedBy = "produto")
    private List<GastoCashless> gastoCashless;

    protected Produto() {
    }

    public Produto(String designacao, double valor) {
        this.designacao = designacao;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Comerciante getComerciante() {
        return comerciante;
    }

    public void setComerciante(Comerciante comerciante) {
        this.comerciante = comerciante;
    }

    public List<GastoCashless> getGastoCashless() {
        return gastoCashless;
    }

    public void setGastoCashless(List<GastoCashless> gastoCashless) {
        this.gastoCashless = gastoCashless;
    }
}
