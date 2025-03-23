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

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }    

    @Override
    public String toString() {
        return "ID: " + id + 
        ", Nome: " + nome + 
        ", Preço: " + preco + 
        ", Quantidade no Estoque: " + qtdEstoque;
    }
    
}
