package br.com.fiap.autofix.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.autofix.model.Veiculo;

@RestController
public class VeiculoController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Veiculo> dados = new ArrayList<>();

    public VeiculoController() {
    }

    @GetMapping("/veiculos")
    public List<Veiculo> index(){
        return this.dados;
    }

    @PostMapping({"/veiculos"})
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo){
        log.info("Cadastrando "+ veiculo.getMarca() + " " + veiculo.getModelo());
        this.dados.add(veiculo);
        return ResponseEntity.status(201).body(veiculo);
    }

    @GetMapping({"/veiculos/{id}"})
    public Veiculo get(@PathVariable Long id){
        log.info("Buscando veiculo ID: "+id);
        return getVeiculo(id);
    }

    @PutMapping({"/veiculo/{id}"})
    public Veiculo update(@PathVariable Long id, @RequestBody Veiculo veiculo){
        log.info("Atualizando veiculo ID: " + veiculo.toString());

        dados.remove(getVeiculo(id));
        veiculo.setId(id);
        dados.add(veiculo);

        return veiculo;
    }

    @DeleteMapping({"/veiculo/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando veiculo ID: " + id);
        dados.remove(getVeiculo(id));
    }

    private Veiculo getVeiculo(Long id) {
        return dados
        .stream()
        .filter(v -> v.getId().equals(id) )
        .findFirst()
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }


}
