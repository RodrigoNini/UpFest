package com.UpFest.App.services;

public interface ProdutoComercianteService {

    boolean addProduto(com.UpFest.App.entities.ProdutoComerciante produtoComerciante);

    boolean listProdutos();

    boolean deleteProduto(Long id_produto);

}
