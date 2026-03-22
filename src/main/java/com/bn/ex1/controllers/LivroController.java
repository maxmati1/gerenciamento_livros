package com.bn.ex1.controllers;

import com.bn.ex1.models.LivroModel;
import com.bn.ex1.services.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
        List<LivroModel> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livro) {
        LivroModel novo = service.criarLivro(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroModel> buscarPorId(@PathVariable Long id) {
        LivroModel livro = service.buscarPorId(id);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        service.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}