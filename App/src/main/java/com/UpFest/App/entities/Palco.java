package com.UpFest.App.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Palco {

    @Id
    @GeneratedValue
    private Long id;
    private String designacao;
    @ManyToOne
    @JsonBackReference(value = "evento-palco")
    private Evento evento;
    @OneToMany(mappedBy = "palco")
    @JsonManagedReference(value = "palco-concerto")
    private List<Concerto> concerto;

    protected Palco(){
    }

    public Palco(String designacao) {
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

    public List<Concerto> getConcerto() {
        return concerto;
    }

    public void setConcerto(List<Concerto> concerto) {
        this.concerto = concerto;
    }

}
