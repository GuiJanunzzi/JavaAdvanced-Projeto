package br.com.fiap.autofix.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.autofix.model.OrdemServico;
import br.com.fiap.autofix.model.Status;
import br.com.fiap.autofix.repository.OrdemServicoRepository;
import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {
    
    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    @PostConstruct
    public void init(){
        var ordemServicos = List.of(
            OrdemServico.builder()
                .descricao("Manutenção preventiva: troca de óleo e filtros.")
                .valorTotal(380.90)
                .status(Status.Concluido)
                .build(),
            OrdemServico.builder()
                .descricao("Alinhamento e balanceamento das quatro rodas.")
                .valorTotal(250.00)
                .status(Status.Concluido)
                .build(),
            OrdemServico.builder()
                .descricao("Substituição da embreagem e revisão geral.")
                .valorTotal(1850.50)
                .status(Status.Em_Andamento)
                .build(),
            OrdemServico.builder()
                .descricao("Troca completa do sistema de freios do veículo.")
                .valorTotal(1199.99)
                .status(Status.Pendente)
                .build()
        );

        ordemServicoRepository.saveAll(ordemServicos);
    }
}
