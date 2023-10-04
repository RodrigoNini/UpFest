package com.UpFest.App.services;

import com.UpFest.App.entities.ProdutoComerciante;
import com.UpFest.App.repositories.ContaCashlessRepository;
import com.UpFest.App.repositories.ProdutoComercianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashlessServiceImp implements CashlessService{

    @Autowired
    ContaCashlessRepository contaCashlessRepository;
    @Autowired
    ProdutoComercianteRepository produtoComercianteRepository;


    @Override
    public boolean addItem(ProdutoComerciante produtoComerciante) {
        produtoComercianteRepository.save(produtoComerciante);
        return false;
    }
}
