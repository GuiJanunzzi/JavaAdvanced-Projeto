package br.com.fiap.autofix.model;

import java.util.Random;

public class OrdemServico {
    private Long id;
    private String descricao;
    private double valorTotal;
    private Status status; //Status: Pendente, Em_Andamento, Concluido
    
    public OrdemServico(Long id, String descricao, double valorTotal, Status status) {
        this.id = id == null ? (new Random()).nextLong() : id;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + 
        ", Descricao: " + descricao + 
        ", Valor Total: " + valorTotal + 
        ", Status: " + status;
    }

    

}
