package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class PagamentoCashless extends Pagamento {

    @ManyToOne
    private ContaCashless conta;

    protected PagamentoCashless() {
    }

}
