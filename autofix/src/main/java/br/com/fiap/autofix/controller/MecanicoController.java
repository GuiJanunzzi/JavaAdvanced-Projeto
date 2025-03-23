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

import br.com.fiap.autofix.model.Mecanico;

@RestController
public class MecanicoController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Mecanico> dados = new ArrayList<>();

    public MecanicoController() {
    }

    @GetMapping({"/mecanicos"})
    public List<Mecanico> index(){
        return this.dados;
    }

    @PostMapping({"/mecanicos"})
    public ResponseEntity<Mecanico> create(@RequestBody Mecanico mecanico){
        log.info("Cadastrando mecânico: " + mecanico.getNome());
        this.dados.add(mecanico);
        return ResponseEntity.ok().body(mecanico);
    }

    @GetMapping({"/mecanicos/{id}"})
    public Mecanico get(@PathVariable Long id){
        log.info("Buscando mecânico ID:" + id);
        return getMecanico(id);
    }

    @PutMapping({"/mecanicos/{id}"})
    public Mecanico update(@PathVariable Long id, @RequestBody Mecanico mecanico){
        log.info("Atualizando mecânico "+ mecanico.toString());

        dados.remove(getMecanico(id));
        mecanico.setId(id);
        dados.add(mecanico);

        return mecanico;    
    }

    @DeleteMapping({"/mecanicos/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando mecânico ID: " + id);
        dados.remove(getMecanico(id));
    }

    private Mecanico getMecanico(Long id) {
        return dados
        .stream()
        .filter(m -> m.getId().equals(id))
        .findFirst()
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

}
