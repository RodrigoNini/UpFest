package com.UpFest.App.entities;

public class BilheteDTO {
    private Long id;
    private String nome;
    private String email;
    private Long serie;

    public BilheteDTO(Long id, String nome, String email, Long serie) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.serie = serie;
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
