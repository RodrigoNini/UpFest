package com.UpFest.App.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Evento {

    @Id
    @GeneratedValue
    private Long id;
    private String designacao;
    @OneToMany(mappedBy = "evento")
    private List<ContaCashless> contaCashless;
    @OneToMany(mappedBy = "evento")
    private List<Bilhete> bilhete;
    @OneToMany(mappedBy = "evento")
    @JsonManagedReference(value="evento-serieBilhetes")
    private List<SerieBilhetes> serieBilhetes;
    @OneToMany(mappedBy = "evento")
    @JsonManagedReference(value = "evento-artista")
    private List<Artista> artista;
    @OneToMany(mappedBy = "evento")
    @JsonManagedReference(value = "evento-concerto")
    private List<Concerto> concerto;
    @OneToMany(mappedBy = "evento")
    @JsonManagedReference(value = "evento-palco")
    private List<Palco> palco;
    @OneToMany(mappedBy = "evento")
    @JsonManagedReference(value = "evento-comerciante")
    private List<Comerciante> comerciante;


    protected Evento(){
    }

    public Evento(String designacao) {
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

    public List<ContaCashless> getContaCashless() {
        return contaCashless;
    }

    public void setContaCashless(List<ContaCashless> contaCashless) {
        this.contaCashless = contaCashless;
    }

    public List<Bilhete> getBilhete() {
        return bilhete;
    }

    public void setBilhete(List<Bilhete> bilhete) {
        this.bilhete = bilhete;
    }

    public List<SerieBilhetes> getSerieBilhetes() {
        return serieBilhetes;
    }

    public void setSerieBilhetes(List<SerieBilhetes> serieBilhetes) {
        this.serieBilhetes = serieBilhetes;
    }

    public List<Artista> getArtista() {
        return artista;
    }

    public void setArtista(List<Artista> artista) {
        this.artista = artista;
    }

    public List<Concerto> getConcerto() {
        return concerto;
    }

    public void setConcerto(List<Concerto> concerto) {
        this.concerto = concerto;
    }

    public List<Palco> getPalco() {
        return palco;
    }

    public void setPalco(List<Palco> palco) {
        this.palco = palco;
    }

    public List<Comerciante> getComerciante() {
        return comerciante;
    }

    public void setComerciante(List<Comerciante> comerciante) {
        this.comerciante = comerciante;
    }

}
