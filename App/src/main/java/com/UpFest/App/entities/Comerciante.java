package com.UpFest.App.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Comerciante {

    @Id
    @GeneratedValue
    private Long id;
    private String designacao;
    @ManyToOne
    private Evento evento;
    @OneToMany(mappedBy = "comerciante")
    private List<ProdutoComerciante> produtoComerciante;

    protected Comerciante(){
    }

    public Comerciante(String designacao) {
        this.designacao = designacao;
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<ProdutoComerciante> getProdutoComerciante() {
        return produtoComerciante;
    }

    public void setProdutoComerciante(List<ProdutoComerciante> produtoComerciante) {
        this.produtoComerciante = produtoComerciante;
    }
}
