package br.com.fiap.autofix.model;

import java.util.Random;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(Long id, String nome, String email, String telefone) {
        this.id = id == null ? (new Random()).nextLong() : id; 
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

}
