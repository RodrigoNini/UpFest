package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.Produto;
import java.util.List;

public interface ProdutoService {


    Produto addProduto(Long id_evento, Long id_comerciante , Produto produto) throws Exception;

    Produto editProduto(Long id_evento, Long id_comerciante, Long id_produto, Produto produto) throws Exception;

    List<Produto> listProdutos(Long id_evento, Long id_comerciante) throws Exception;




}
