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

import br.com.fiap.autofix.model.OrdemServico;

@RestController
public class OrdemServicoController {
    private List<OrdemServico> dados = new ArrayList<>();

    public OrdemServicoController() {
    }

    @GetMapping({"/ordem-servico"})
    public List<OrdemServico> index(){
        return this.dados;
    }

    @PostMapping({"/ordem-servico"})
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico ordemServico){
        this.dados.add(ordemServico);
        return ResponseEntity.status(210).body(ordemServico);
    }

    @GetMapping({"/ordem-servico/{id}"})
    public ResponseEntity<OrdemServico> get(@PathVariable Long id){
        Optional<OrdemServico> ordemServico = this.dados.stream().filter((o) -> {
            return o.getId().equals(id);
        }).findFirst();
        return ordemServico.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok((OrdemServico)ordemServico.get());
    }

}
