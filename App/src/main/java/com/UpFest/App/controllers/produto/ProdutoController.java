package com.UpFest.App.controllers.produto;

import com.UpFest.App.entities.ProdutoComerciante;
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
    public ResponseEntity<?> addProduto(@PathVariable Long id_evento, @PathVariable Long id_comerciante, @RequestBody ProdutoComerciante produtoComerciante){

        try{
            ProdutoComerciante produtoComercianteCriado = produtoService.addProduto(id_evento, id_comerciante, produtoComerciante);
            return ResponseEntity.ok("O produto '" + produtoComercianteCriado.getDesignacao() + "' foi adicionado ao comerciante com o ID " + id_comerciante + " no evento com o ID " + id_evento + " na base de dados.");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("{id_evento}/comerciantes/{id_comerciante}/produtos/{id_produto}/editar")
    public ResponseEntity<?> editProduto(@PathVariable Long id_evento, @PathVariable Long id_comerciante, @PathVariable Long id_produto, @RequestBody ProdutoComerciante produtoComerciante){

        try {
            ProdutoComerciante produtoComercianteEditado = produtoService.editProduto(id_evento, id_comerciante, id_produto, produtoComerciante);
            return ResponseEntity.ok("O produto com o ID '" + produtoComercianteEditado.getId() + "' foi atualizado para '" + produtoComercianteEditado.getDesignacao() + "' no comerciante com o ID " + id_comerciante + " no evento com o ID " + id_evento + " na base de dados.");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("{id_evento}/comerciantes/{id_comerciante}/produtos/listar")
    public ResponseEntity<?> listProdutos(@PathVariable Long id_evento, @PathVariable Long id_comerciante){
        try{
            List<ProdutoComerciante> produtoComerciantes = produtoService.listProdutos(id_evento, id_comerciante);
            return ResponseEntity.ok(produtoComerciantes);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
