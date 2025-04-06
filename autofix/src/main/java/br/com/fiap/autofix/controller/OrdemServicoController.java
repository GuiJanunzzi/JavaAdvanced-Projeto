package br.com.fiap.autofix.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.autofix.model.OrdemServico;

@RestController
@CrossOrigin
public class OrdemServicoController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<OrdemServico> dados = new ArrayList<>();

    public OrdemServicoController() {
    }

    @GetMapping({"/ordem-servico"})
    public List<OrdemServico> index(){
        return this.dados;
    }

    @PostMapping({"/ordem-servico"})
    public ResponseEntity<OrdemServico> create(@RequestBody OrdemServico ordemServico){
        log.info("Cadastrando Ordem de Serviço");
        this.dados.add(ordemServico);
        return ResponseEntity.status(210).body(ordemServico);
    }

    @GetMapping({"/ordem-servico/{id}"})
    public OrdemServico get(@PathVariable Long id){
        log.info("Buscando ordem de serviço ID: " + id);
        return getOrdemServico(id);
    }

    @PostMapping({"/ordem-servico/{id}"})
    public OrdemServico update(@PathVariable Long id, @RequestBody OrdemServico ordemServico){
        log.info("Atualizando ordem de serviço "+ordemServico.toString());

        dados.remove(getOrdemServico(id));
        ordemServico.setId(id);
        dados.add(ordemServico);

        return ordemServico;
    }

    @DeleteMapping({"/ordem-servico/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando Ordem de Serviço ID: " + id);
        dados.remove(getOrdemServico(id));
    }

    private OrdemServico getOrdemServico(Long id) {
        return dados
        .stream()
        .filter(o -> o.getId().equals(id))
        .findFirst()
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }



}
