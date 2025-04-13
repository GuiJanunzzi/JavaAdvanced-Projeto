package br.com.fiap.autofix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity//Transforma a classe em uma tabela de banco de dados
@Data//Gerar dados com Lombok
public class OrdemServico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double valorTotal;
    private Status status; //Status: Pendente, Em_Andamento, Concluido   
}
