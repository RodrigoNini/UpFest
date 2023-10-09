package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.Comerciante;
import com.UpFest.App.entities.ProdutoComerciante;
import com.UpFest.App.repositories.cashless.ComercianteRepository;
import com.UpFest.App.repositories.cashless.ProdutoComercianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImp implements ProdutoService {


    @Autowired
    ComercianteRepository comercianteRepository;

    @Autowired
    ProdutoComercianteRepository produtoComercianteRepository;


    @Override
    public ProdutoComerciante addProduto(Long id_evento, Long id_comerciante, ProdutoComerciante produtoComerciante) throws Exception {

        Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);

        String nameOfProduto = produtoComerciante.getDesignacao();
        if(nameOfProduto == null || nameOfProduto.isEmpty()){
            throw new Exception("'designacao' de produto não pode ser null.");
        }

        if(!comercianteOnDB.isPresent()){
            throw new Exception("O Comerciante com o ID " + id_comerciante + " não existe.");
        }

        if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
            throw new Exception("O evento com o ID " + id_evento + " não existe.");
        }

        produtoComerciante.setComerciante(comercianteOnDB.get());

        return produtoComercianteRepository.save(produtoComerciante);

    }

    @Override
    public ProdutoComerciante editProduto(Long id_evento, Long id_comerciante, Long id_produto, ProdutoComerciante produtoComerciante) throws Exception {

        Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);
        Optional<ProdutoComerciante> produtoOnDB = produtoComercianteRepository.findById(id_produto);

        if(!comercianteOnDB.isPresent()){
            throw new Exception("O Comerciante com o ID " + id_comerciante + " não existe.");
        }

        if(!produtoOnDB.isPresent()){
            throw new Exception("O Produto com o ID " + id_produto + " não existe.");
        }

        if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
            throw new Exception("O evento com o ID " + id_evento + " não existe.");
        }

        String nameOfProduto = produtoComerciante.getDesignacao();
        if(nameOfProduto == null || nameOfProduto.isEmpty()){
            throw new Exception("A 'designacao' do produto não pode ser null.");
        }

        produtoComerciante.setId(id_produto);
        produtoComerciante.setComerciante(comercianteOnDB.get());

        return produtoComercianteRepository.save(produtoComerciante);

    }

    @Override
    public List<ProdutoComerciante> listProdutos(Long id_evento, Long id_comerciante) throws Exception {

            Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);
        if(!comercianteOnDB.isPresent()){
            throw new Exception("O Comerciante com o ID " + id_comerciante + " não existe.");
        }

        if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
            throw new Exception("O evento com o ID " + id_evento + " não existe.");
        }

        List<ProdutoComerciante> produtoComerciantes = produtoComercianteRepository.findByComercianteId(comercianteOnDB.get().getId());

        return produtoComerciantes;
    }
}
