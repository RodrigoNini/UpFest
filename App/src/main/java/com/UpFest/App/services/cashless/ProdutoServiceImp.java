package com.UpFest.App.services.cashless;

import com.UpFest.App.entities.Comerciante;
import com.UpFest.App.entities.Evento;
import com.UpFest.App.entities.Palco;
import com.UpFest.App.entities.Produto;
import com.UpFest.App.repositories.cashless.ComercianteRepository;
import com.UpFest.App.repositories.cashless.ProdutoRepository;
import com.UpFest.App.repositories.evento.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImp implements ProdutoService {


    @Autowired
    ComercianteRepository comercianteRepository;

    @Autowired
    ProdutoRepository produtoRepository;


    @Override
    public Produto addProduto(Long id_evento, Long id_comerciante, Produto produto) throws Exception {

        Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);
        Optional<Produto> produtoOnDB = produtoRepository.findById(id_comerciante);

        if (produtoOnDB.isPresent()) {
            throw new Exception("Produto com o ID " + id_comerciante + " já existe.");
        }

        String nameOfProduto = produto.getDesignacao();
        if(nameOfProduto == null || nameOfProduto.isEmpty()){
            throw new Exception("'designacao' de produto não pode ser null.");
        }

        if(!comercianteOnDB.isPresent()){
            throw new Exception("O Comerciante com o ID " + id_comerciante + " não existe.");
        }

        if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
            throw new Exception("O evento com o ID " + id_evento + " não existe.");
        }

        produto.setComerciante(comercianteOnDB.get());

        return produtoRepository.save(produto);

    }

    @Override
    public Produto editProduto(Long id_evento, Long id_comerciante, Long id_produto, Produto produto) throws Exception {

        Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);
        Optional<Produto> produtoOnDB = produtoRepository.findById(id_produto);

        if(!comercianteOnDB.isPresent()){
            throw new Exception("O Comerciante com o ID " + id_comerciante + " não existe.");
        }

        if(!produtoOnDB.isPresent()){
            throw new Exception("O Produto com o ID " + id_produto + " não existe.");
        }

        if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
            throw new Exception("O evento com o ID " + id_evento + " não existe.");
        }

        String nameOfProduto = produto.getDesignacao();
        if(nameOfProduto == null || nameOfProduto.isEmpty()){
            throw new Exception("A 'designacao' do produto não pode ser null.");
        }

        produto.setId(id_produto);
        produto.setComerciante(comercianteOnDB.get());

        return produtoRepository.save(produto);

    }

    @Override
    public List<Produto> listProdutos(Long id_evento, Long id_comerciante) throws Exception {

            Optional<Comerciante> comercianteOnDB = comercianteRepository.findById(id_comerciante);
        if(!comercianteOnDB.isPresent()){
            throw new Exception("O Comerciante com o ID " + id_comerciante + " não existe.");
        }

        if(!comercianteOnDB.get().getEvento().getId().equals(id_evento)){
            throw new Exception("O evento com o ID " + id_evento + " não existe.");
        }

        List<Produto> produtos = produtoRepository.findByComercianteId(comercianteOnDB.get().getId());

        return produtos;
    }
}
