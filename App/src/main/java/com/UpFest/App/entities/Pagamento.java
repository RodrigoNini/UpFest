package com.UpFest.App.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento {

    @Id
    @GeneratedValue
    private Long id;
    private int entidade;
    private int referencia;
    private double valor;
    private Date data_compra;
    private Date data_validado;
    @OneToMany(mappedBy = "pagamento")
    private List<Bilhete> bilhete;

    protected Pagamento() {
    }


    public Pagamento(Long id, int entidade, int referencia, double valor, Date data_compra, Date data_validado) {
        this.id = id;
        this.entidade = entidade;
        this.referencia = referencia;
        this.valor = valor;
        this.data_compra = data_compra;
        this.data_validado = data_validado;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEntidade() {
        return entidade;
    }

    public void setEntidade(int entidade) {
        this.entidade = entidade;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public Date getData_validado() {
        return data_validado;
    }

    public void setData_validado(Date data_validado) {
        this.data_validado = data_validado;
    }
}
