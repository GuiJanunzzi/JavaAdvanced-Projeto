package br.com.fiap.autofix.model;

public class Mecanico {
    private Long id;
    private String nome;
    private String especialidade;
    
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
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Especialidade: " + especialidade;
    }
    
    

}
