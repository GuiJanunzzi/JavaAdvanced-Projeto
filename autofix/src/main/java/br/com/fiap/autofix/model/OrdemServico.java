package br.com.fiap.autofix.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity//Transforma a classe em uma tabela de banco de dados
@Data//Gerar dados com Lombok
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdemServico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID gerado automaticamente da ordem de serviço", example = "1", readOnly = true)
    private Long id;

    @NotBlank(message = "Campo obrigatório!")
    @Size(min = 10, max = 255, message = "O Campo deve ter entre 10 à 255 caracteres!")
    @Schema(description = "Descrição detalhada da ordem de serviço", example = "Troca do sistema de freios")
    private String descricao;

    @NotNull(message = "Campo obrigatório!")
    @Positive(message = "O valor deve ser maior que zero")
    @Schema(description = "Valor total da ordem de serviço", example = "1500.00")
    private double valorTotal;

    @NotNull(message = "Campo obrigatório!")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Status atual da ordem de serviço", example = "PENDENTE")
    private Status status; //Status: Pendente, Em_Andamento, Concluido   
}
