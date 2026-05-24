package com.hbc.cadastro.controller;

import com.hbc.cadastro.model.Pessoa;
import com.hbc.cadastro.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/pessoa"})
public class PessoaController {

    private final PessoaRepository repository;

    public PessoaController(PessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa pessoa){
        return repository.save(pessoa);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa){

        return repository.findById(id)
                .map(record -> {
            record.setNome(pessoa.getNome());
            record.setSobreNome(pessoa.getSobreNome());
            record.setTelefone(pessoa.getTelefone());
            record.setEmail(pessoa.getEmail());
            Pessoa updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return repository.findById(id)
                .map(_ -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}