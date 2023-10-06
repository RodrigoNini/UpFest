package com.UpFest.App.entities;

import java.util.Date;

public class ConcertoDTO {
    private Long artista;
    private Long palco;
    private Date data_hora_inicio;
    private Date data_hora_fim;

    public ConcertoDTO(Long artista, Long palco, Date data_hora_inicio, Date data_hora_fim) {
        this.artista = artista;
        this.palco = palco;
        this.data_hora_inicio = data_hora_inicio;
        this.data_hora_fim = data_hora_fim;
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

    @Override
    public String toString() {
        return "ConcertoDTO{" +
                "artista=" + artista +
                ", palco=" + palco +
                ", data_hora_inicio=" + data_hora_inicio +
                ", data_hora_fim=" + data_hora_fim +
                '}';
    }
}
