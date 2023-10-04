package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class CarregamentoCashless extends MovimentoCashless {

    @ManyToOne
    private PagamentoCashless pagamento;

    protected CarregamentoCashless() {
    }

}
