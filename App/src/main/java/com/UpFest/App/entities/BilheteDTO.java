package com.UpFest.App.entities;

public class BilheteDTO {
    private Long evento;
    private String nome;
    private String email;
    private Long serie;

    public BilheteDTO(Long evento, String nome, String email, Long serie) {
        this.evento = evento;
        this.nome = nome;
        this.email = email;
        this.serie = serie;
    }

    public Long getEvento() {
        return evento;
    }

    public void setEvento(Long evento) {
        this.evento = evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSerie() {
        return serie;
    }

    public void setSerie(Long serie) {
        this.serie = serie;
    }
}
