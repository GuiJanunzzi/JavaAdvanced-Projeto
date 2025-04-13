package br.com.fiap.autofix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity//Transforma a classe em uma tabela de banco de dados
@Data//Gerar dados com Lombok
public class OrdemServico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório!")
    @Size(min = 10, max = 255, message = "O Campo deve ter entre 10 à 255 caracteres!")
    private String descricao;

    @NotNull(message = "Campo obrigatório!")
    @Positive(message = "O valor deve ser maior que zero")
    private double valorTotal;

    @NotNull(message = "Campo obrigatório!")
    @Enumerated(EnumType.STRING)
    private Status status; //Status: Pendente, Em_Andamento, Concluido   
}
