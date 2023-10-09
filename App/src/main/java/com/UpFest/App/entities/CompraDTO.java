package com.UpFest.App.entities;

public class CompraDTO {

    private String participante;
    private Long produto;
    private int quantidade;


    public CompraDTO(String participante, Long produto, int quantidade) {
        this.participante = participante;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getParticipante() {
        return participante;
    }

    public void setParticipante(String participante) {
        this.participante = participante;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
