package br.com.fiap.autofix.model;

import java.util.Random;

public class Mecanico {
    private Long id;
    private String nome;
    private String especialidade;
    
    public Mecanico(Long id, String nome, String especialidade) {
        this.id = id == null ? (new Random()).nextLong() : id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

}
