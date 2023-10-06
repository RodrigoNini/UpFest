package com.UpFest.App.controllers.produto;

import com.UpFest.App.entities.Produto;
import com.UpFest.App.services.cashless.ProdutoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
@RequestMapping("/cashless")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImp produtoService;


    @PostMapping("{id_evento}/comerciantes/{id_comerciante}/produtos/criar")
    public ResponseEntity<?> addProduto(@PathVariable Long id_evento, @PathVariable Long id_comerciante, @RequestBody Produto produto){

        try{
            Produto produtoCriado = produtoService.addProduto(id_evento, id_comerciante, produto);
            return ResponseEntity.ok("O produto '" + produtoCriado.getDesignacao() + "' foi adicionado ao comerciante com o ID " + id_comerciante + " no evento com o ID " + id_evento + " na base de dados.");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("{id_evento}/comerciantes/{id_comerciante}/produtos/{id_produto}/editar")
    public ResponseEntity<?> editProduto(@PathVariable Long id_evento, @PathVariable Long id_comerciante, @PathVariable Long id_produto, @RequestBody Produto produto){

        try {
            Produto produtoEditado = produtoService.editProduto(id_evento, id_comerciante, id_produto, produto);
            return ResponseEntity.ok("O produto com o ID '" + produtoEditado.getId() + "' foi atualizado para '" + produtoEditado.getDesignacao() + "' no comerciante com o ID " + id_comerciante + " no evento com o ID " + id_evento + " na base de dados.");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("{id_evento}/comerciantes/{id_comerciante}/produtos/listar")
    public ResponseEntity<?> listProdutos(@PathVariable Long id_evento, @PathVariable Long id_comerciante){
        try{
            List<Produto> produtos = produtoService.listProdutos(id_evento, id_comerciante);
            return ResponseEntity.ok(produtos);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
