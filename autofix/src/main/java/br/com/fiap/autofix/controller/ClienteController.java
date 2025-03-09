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

import br.com.fiap.autofix.model.Cliente;

@RestController
public class ClienteController {
    private List<Cliente> dados = new ArrayList<>();

    public ClienteController() {
    }

    @GetMapping({"/clientes"})
    public List<Cliente> index(){
        return this.dados;
    }

    @PostMapping({"/clientes"})
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        this.dados.add(cliente);
        return ResponseEntity.status(201).body(cliente);
    }

    @GetMapping({"/clientes/{id}"})
    public ResponseEntity<Cliente> get(@PathVariable Long id){
        Optional<Cliente> cliente = this.dados.stream().filter((c) ->{
            return c.getId().equals(id);
        }).findFirst();
        return cliente.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok((Cliente)cliente.get());
    }
    
}
