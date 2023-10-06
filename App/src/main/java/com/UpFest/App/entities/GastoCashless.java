package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class GastoCashless extends MovimentoCashless {

    private int quantidade;
    private double valorUnitario;
    @ManyToOne
    private Produto produto;


    protected GastoCashless() {
    }

    public GastoCashless(int quantidade, double valorUnitario) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Produto getProdutoComerciante() {
        return produto;
    }

    public void setProdutoComerciante(Produto produto) {
        this.produto = produto;
    }
}
