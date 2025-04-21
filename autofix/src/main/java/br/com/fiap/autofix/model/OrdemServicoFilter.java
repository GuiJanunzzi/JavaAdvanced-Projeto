package br.com.fiap.autofix.model;

public record OrdemServicoFilter(
        Double valorMin,
        Double valorMax,
        Status status){
}
