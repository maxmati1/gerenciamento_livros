package com.bn.ex1.services;

import com.bn.ex1.models.LivroModel;
import com.bn.ex1.repositories.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public LivroModel criarLivro(LivroModel livro) {
        return repository.save(livro);
    }

    public List<LivroModel> findAll() {
        return repository.findAll();
    }

    public LivroModel buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }
}