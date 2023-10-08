package com.UpFest.App.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bilhete {

    @Id
    @GeneratedValue
    private Long id;
    private String codigo;

    @ManyToOne
    private Participante participante;
    @ManyToOne
    private Evento evento;
    @ManyToOne
    private SerieBilhetes serieBilhetes;
    @ManyToOne
    private Pagamento pagamento;
    @OneToMany(mappedBy = "bilhete")
    private List<Entrada> entrada;


    protected Bilhete() {
    }

    public Bilhete(Long id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public SerieBilhetes getSerieBilhetes() {
        return serieBilhetes;
    }

    public void setSerieBilhetes(SerieBilhetes serieBilhetes) {
        this.serieBilhetes = serieBilhetes;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<Entrada> getEntrada() {
        return entrada;
    }

    public void setEntrada(List<Entrada> entrada) {
        this.entrada = entrada;
    }
}
