package com.UpFest.App.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artista {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String estilo;
    private String biografia;

    @ManyToOne
    private Evento evento;

    @OneToMany(mappedBy = "artista")
    private List<Concerto> concerto;

    protected Artista(){
    }

    public Artista(String nome, String estilo, String biografia) {
        this.nome = nome;
        this.estilo = estilo;
        this.biografia = biografia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public List<Concerto> getConcerto() {
        return concerto;
    }

    public void setConcerto(List<Concerto> concerto) {
        this.concerto = concerto;
    }
}
