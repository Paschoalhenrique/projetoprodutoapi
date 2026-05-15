package com.curso.produtoapi.controller;
import com.curso.produtoapi.model.Produto;
import com.curso.produtoapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido teste: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;

    }
    @GetMapping("{id}")
    public Produto ObterProId(@PathVariable ("id")String id){
       return produtoRepository.findById(id).orElse(null);
    }

}
