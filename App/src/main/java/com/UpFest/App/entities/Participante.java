package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


@Entity
public class Participante {

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String nome;
    private Date data_registo;
    @OneToMany(mappedBy = "participante")
    private List<Bilhete> bilhete;
    @OneToMany(mappedBy = "participante")
    private List<ContaCashless> contaCashless;

    protected Participante() {
    }

    public Participante( String email, String nome, Date data_registo) {
        this.email = email;
        this.nome = nome;
        this.data_registo = data_registo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_registo() {
        return data_registo;
    }

    public void setData_registo(Date data_registo) {
        this.data_registo = data_registo;
    }
}