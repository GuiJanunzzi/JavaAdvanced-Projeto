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

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "ID: " + id + 
        ", Marca: " + marca + 
        ", Modelo: " + modelo + 
        ", Placa:" + placa + 
        ", Ano: " + ano;
    }

    

}
