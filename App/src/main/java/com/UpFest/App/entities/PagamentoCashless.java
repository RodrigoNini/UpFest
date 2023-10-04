package com.UpFest.App.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class PagamentoCashless extends Pagamento {

    @OneToMany(mappedBy = "pagamentoCashless")
    private List<CarregamentoCashless> carregamentoCashlesses;
    @ManyToOne
    private ContaCashless contaCashless;

    protected PagamentoCashless() {
    }

}
