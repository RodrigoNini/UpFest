package com.UpFest.App.entities;

import com.UpFest.App.enumerados.Tipo;
import com.UpFest.App.repositories.cashless.ContaCashlessRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
public class GastoCashless extends MovimentoCashless {

    private int quantidade;
    private double valorUnitario;
    @ManyToOne
    @JsonBackReference(value = "produtoComerciante-gastoCashless")
    private ProdutoComerciante produtoComerciante;

    protected GastoCashless() {
    }

    public GastoCashless(int quantidade, double valorUnitario, double saldo) {

        super(Tipo.GASTO, quantidade * valorUnitario, saldo - (quantidade * valorUnitario), new Date());
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
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

    public ProdutoComerciante getProdutoComerciante() {
        return produtoComerciante;
    }

    public void setProdutoComerciante(ProdutoComerciante produtoComerciante) {
        this.produtoComerciante = produtoComerciante;
    }

    @Override
    public String toString() {
        return "GastoCashless{" +
                "quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", produtoComerciante=" + produtoComerciante +
                '}';
    }
}
