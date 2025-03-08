package br.com.fiap.autofix.model;

import java.util.Random;

public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;

    public Veiculo(Long id, String marca, String modelo, String placa, int ano) {
        this.id = id == null ? (new Random()).nextLong() : id;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

}
