package br.com.fiap.autofix.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.autofix.model.Peca;

@RestController
public class PecaController {
    private List<Peca> dados = new ArrayList<>();

    public PecaController() {
    }

    @GetMapping({"/pecas"})
    public List<Peca> index(){
        return this.dados;
    }

    @PostMapping({"/pecas"})
    public ResponseEntity<Peca> create(@RequestBody Peca peca){
        this.dados.add(peca);
        return ResponseEntity.status(201).body(peca);
    }

    @GetMapping({"/pecas/{id}"})
    public ResponseEntity<Peca> get(@PathVariable Long id){
        Optional<Peca> peca = this.dados.stream().filter((p) -> {
            return p.getId().equals(id);
        }).findFirst();
        return peca.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok((Peca) peca.get());
    }

}
