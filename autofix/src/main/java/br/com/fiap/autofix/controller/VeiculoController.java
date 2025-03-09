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

import br.com.fiap.autofix.model.Veiculo;

@RestController
public class VeiculoController {
    private List<Veiculo> dados = new ArrayList<>();

    public VeiculoController() {
    }

    @GetMapping("/veiculos")
    public List<Veiculo> index(){
        return this.dados;
    }

    @PostMapping({"/veiculos"})
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo){
        this.dados.add(veiculo);
        return ResponseEntity.status(201).body(veiculo);
    }

    @GetMapping({"/veiculos/{id}"})
    public ResponseEntity<Veiculo> get(@PathVariable Long id){
        Optional<Veiculo> veiculo = this.dados.stream().filter((v) -> {
            return v.getId().equals(id);
        }).findFirst();
        return veiculo.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok((Veiculo)veiculo.get());
    }


}
