package com.UpFest.App.entities;

import com.UpFest.App.enumerados.Tipo;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class MovimentoCashless {
    @Id
    @GeneratedValue
    private Long id;
    private Tipo tipo;
    private double valor;
    private double saldo;
    private Date data;
    @ManyToOne
    private ContaCashless contaCashless;

    protected MovimentoCashless() {
    }

    public MovimentoCashless(Long id, Tipo tipo, double valor, double saldo, Date data) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.saldo = saldo;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ContaCashless getContaCashless() {
        return contaCashless;
    }

    public void setContaCashless(ContaCashless contaCashless) {
        this.contaCashless = contaCashless;
    }
}
