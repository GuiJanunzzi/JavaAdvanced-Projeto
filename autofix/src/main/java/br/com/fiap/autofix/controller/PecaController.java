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

import br.com.fiap.autofix.model.Peca;

@RestController
public class PecaController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Peca> dados = new ArrayList<>();

    public PecaController() {
    }

    @GetMapping({"/pecas"})
    public List<Peca> index(){
        return this.dados;
    }

    @PostMapping({"/pecas"})
    public ResponseEntity<Peca> create(@RequestBody Peca peca){
        log.info("Cadastrando " + peca.getNome());
        this.dados.add(peca);
        return ResponseEntity.status(201).body(peca);
    }

    @GetMapping({"/pecas/{id}"})
    public Peca get(@PathVariable Long id){
        log.info("Buscando peça ID: "+id);
        return getPeca(id);
    }

    @PutMapping({"/pecas/{id}"})
    public Peca update(@PathVariable Long id, @RequestBody Peca peca){
        log.info("Atualizando peça " + id + " " + peca.toString());

        dados.remove(getPeca(id));
        peca.setId(id);
        dados.add(peca);

        return peca;
    }

    @DeleteMapping({"/pecas/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando peça ID: "+id);
        dados.remove(getPeca(id));
    }

    private Peca getPeca(Long id) {
        return dados
           .stream()
           .filter(p -> p.getId().equals(id))
           .findFirst()
           .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
           );
    }

}
