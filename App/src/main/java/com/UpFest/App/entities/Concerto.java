package com.UpFest.App.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;


@Entity
public class Concerto {

    @Id
    @GeneratedValue
    private Long id;
    private Date dataHoraInicio;
    private Date dataHoraFim;

    @ManyToOne
    @JsonBackReference(value = "evento-concerto")
    private Evento evento;

    @ManyToOne
    @JsonBackReference(value = "artista-concerto")
    private Artista artista;

    @ManyToOne
    @JsonBackReference(value = "palco-concerto")
    private Palco palco;

    protected Concerto() {
    }

    public Concerto(Date dataHoraInicio, Date dataHoraFim) {
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Palco getPalco() {
        return palco;
    }

    public void setPalco(Palco palco) {
        this.palco = palco;
    }
}
