package com.UpFest.App.services;

import com.UpFest.App.repositories.ProdutoComercianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoComercianteServiceImp implements ProdutoComercianteService {

    @Autowired
    ProdutoComercianteRepository produtoComercianteRepository;

    @Override
    public boolean addProduto(com.UpFest.App.entities.ProdutoComerciante produtoComerciante) {
        produtoComercianteRepository.save(produtoComerciante);
        return false;
    }

    @Override
    public boolean listProdutos() {
        produtoComercianteRepository.findAll();
        return false;
    }

    @Override
    public boolean deleteProduto(Long id_produto) {
        produtoComercianteRepository.deleteById(id_produto);
        return false;
    }

}
