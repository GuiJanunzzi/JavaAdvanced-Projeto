package br.com.fiap.autofix.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.autofix.model.OrdemServico;
import br.com.fiap.autofix.repository.OrdemServicoRepository;

@RestController
@CrossOrigin
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private OrdemServicoRepository repository;

    //
    @GetMapping
    public List<OrdemServico> index(){
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico ordemServico){
        log.info("Cadastrando Ordem de Serviço");
        repository.save(ordemServico);
        return ResponseEntity.status(210).body(ordemServico);
    }

    @GetMapping({"/{id}"})
    public OrdemServico get(@PathVariable Long id){
        log.info("Buscando ordem de serviço ID: " + id);
        return getOrdemServico(id);
    }

    @PutMapping
    public OrdemServico update(@PathVariable Long id, @RequestBody OrdemServico ordemServico){
        log.info("Atualizando ordem de serviço "+ordemServico.toString());

        getOrdemServico(id);
        ordemServico.setId(id);
        repository.save(ordemServico);

        return ordemServico;
    }

    @DeleteMapping({"/ordem-servico/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando Ordem de Serviço ID: " + id);
        repository.delete(getOrdemServico(id));
    }

    private OrdemServico getOrdemServico(Long id) {
        return repository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

}