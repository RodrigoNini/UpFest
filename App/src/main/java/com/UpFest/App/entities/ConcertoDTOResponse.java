package com.UpFest.App.entities;

import java.util.Date;

public class ConcertoDTOResponse {

    private Long id_concerto;
    private Long artista;
    private Long palco;
    private Date data_hora_inicio;
    private Date data_hora_fim;

    public ConcertoDTOResponse(Long id_concerto, Long artista, Long palco, Date data_hora_inicio, Date data_hora_fim) {
        this.id_concerto = id_concerto;
        this.artista = artista;
        this.palco = palco;
        this.data_hora_inicio = data_hora_inicio;
        this.data_hora_fim = data_hora_fim;
    }

    public Long getId_concerto() {
        return id_concerto;
    }

    public void setId_concerto(Long id_concerto) {
        this.id_concerto = id_concerto;
    }

    public Long getArtista() {
        return artista;
    }

    public void setArtista(Long artista) {
        this.artista = artista;
    }

    public Long getPalco() {
        return palco;
    }

    public void setPalco(Long palco) {
        this.palco = palco;
    }

    public Date getData_hora_inicio() {
        return data_hora_inicio;
    }

    public void setData_hora_inicio(Date data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public Date getData_hora_fim() {
        return data_hora_fim;
    }

    public void setData_hora_fim(Date data_hora_fim) {
        this.data_hora_fim = data_hora_fim;
    }
}
