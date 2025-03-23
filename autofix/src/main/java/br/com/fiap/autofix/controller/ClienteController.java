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

import br.com.fiap.autofix.model.Cliente;

@RestController
public class ClienteController {

    private Logger log = LoggerFactory.getLogger(getClass());
    private List<Cliente> dados = new ArrayList<>();

    public ClienteController() {
    }

    @GetMapping({"/clientes"})
    public List<Cliente> index(){
        return dados;
    }

    @PostMapping({"/clientes"})
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        log.info("Cadastrando cliente: " + cliente.getNome());
        dados.add(cliente);
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping({"/clientes/{id}"})
    public Cliente get(@PathVariable Long id){
        log.info("Buscando cliente ID: " + id);
        return getCliente(id);
    }

    @PutMapping({"/clientes/{id}"})
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente){
        log.info("Atualizando cliente " + cliente.toString());

        dados.remove(getCliente(id));
        cliente.setId(id);
        dados.add(cliente);

        return cliente;
    }

    @DeleteMapping({"/clientes/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando cliente ID:" + id);
        dados.remove(getCliente(id));
    }

    private Cliente getCliente(Long id) {
        return dados
        .stream()
        .filter( c -> c.getId().equals(id))
        .findFirst()
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

    }
    
}
