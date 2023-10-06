package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.ProdutoComerciante;
import java.util.List;

public interface ProdutoService {


    ProdutoComerciante addProduto(Long id_evento, Long id_comerciante , ProdutoComerciante produtoComerciante) throws Exception;

    ProdutoComerciante editProduto(Long id_evento, Long id_comerciante, Long id_produto, ProdutoComerciante produtoComerciante) throws Exception;

    List<ProdutoComerciante> listProdutos(Long id_evento, Long id_comerciante) throws Exception;




}
