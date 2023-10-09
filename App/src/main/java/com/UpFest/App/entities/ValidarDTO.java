package com.UpFest.App.entities;

public class ValidarDTO {
    private Long evento;
    private String codigo;

    public ValidarDTO(Long evento, String codigo) {
        this.evento = evento;
        this.codigo = codigo;
    }

    public Long getEvento() {
        return evento;
    }

    public void setEvento(Long evento) {
        this.evento = evento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
