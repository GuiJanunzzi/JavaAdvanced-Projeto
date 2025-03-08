package br.com.fiap.autofix.model;

import java.util.Random;

public class Peca {
    private Long id;
    private String nome;
    private double preco;
    private int qtdEstoque;

    public Peca(Long id, String nome, double preco, int qtdEstoque) {
        this.id = id == null ? (new Random()).nextLong() : id;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }    

}
