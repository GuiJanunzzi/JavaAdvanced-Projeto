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

    public String getDescricao() {
        return descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public Status getStatus() {
        return status;
    }    

}
