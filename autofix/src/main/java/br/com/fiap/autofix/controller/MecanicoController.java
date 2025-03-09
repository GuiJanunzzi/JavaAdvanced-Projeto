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

import br.com.fiap.autofix.model.Mecanico;

@RestController
public class MecanicoController {
    private List<Mecanico> dados = new ArrayList<>();

    public MecanicoController() {
    }

    @GetMapping({"/mecanicos"})
    public List<Mecanico> index(){
        return this.dados;
    }

    @PostMapping({"/mecanicos"})
    public ResponseEntity<Mecanico> create(@RequestBody Mecanico mecanico){
        this.dados.add(mecanico);
        return ResponseEntity.ok().body(mecanico);
    }

    @GetMapping({"/mecanicos/{id}"})
    public ResponseEntity<Mecanico> get(@PathVariable Long id){
        Optional<Mecanico> mecanico = this.dados.stream().filter((m) -> {
            return m.getId().equals(id);
        }).findFirst();
        return mecanico.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok((Mecanico) mecanico.get());
    }

}
