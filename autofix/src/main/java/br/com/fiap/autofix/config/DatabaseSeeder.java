package br.com.fiap.autofix.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.autofix.model.OrdemServico;
import br.com.fiap.autofix.model.Status;
import br.com.fiap.autofix.model.Usuario;
import br.com.fiap.autofix.model.UsuarioRole;
import br.com.fiap.autofix.repository.OrdemServicoRepository;
import br.com.fiap.autofix.repository.UsuarioRepository;
import jakarta.annotation.PostConstruct;

@Configuration
public class DatabaseSeeder {
    
    @Autowired
    OrdemServicoRepository ordemServicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    DatabaseSeeder(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

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
                .build(),

            OrdemServico.builder()
                .descricao("Instalação de sistema de ar-condicionado.")
                .valorTotal(1450.00)
                .status(Status.Pendente)
                .build(),

            OrdemServico.builder()
                .descricao("Reparo elétrico: substituição de fusíveis e relés.")
                .valorTotal(295.75)
                .status(Status.Em_Andamento)
                .build(),

            OrdemServico.builder()
                .descricao("Alinhamento e balanceamento das quatro rodas.")
                .valorTotal(120.00)
                .status(Status.Concluido)
                .build(),

            OrdemServico.builder()
                .descricao("Troca de pastilhas de freio dianteiras e traseiras.")
                .valorTotal(430.50)
                .status(Status.Concluido)
                .build(),

            OrdemServico.builder()
                .descricao("Limpeza completa do sistema de arrefecimento.")
                .valorTotal(250.00)
                .status(Status.Em_Andamento)
                .build(),

            OrdemServico.builder()
                .descricao("Revisão dos 20.000km com troca de filtros e revisão geral.")
                .valorTotal(680.00)
                .status(Status.Concluido)
                .build(),

            OrdemServico.builder()
                .descricao("Troca de bateria e reconfiguração do sistema eletrônico.")
                .valorTotal(520.99)
                .status(Status.Pendente)
                .build(),

            OrdemServico.builder()
                .descricao("Reparo na suspensão dianteira.")
                .valorTotal(790.30)
                .status(Status.Em_Andamento)
                .build(),

            OrdemServico.builder()
                .descricao("Polimento e cristalização da pintura.")
                .valorTotal(350.00)
                .status(Status.Concluido)
                .build(),

            OrdemServico.builder()
                .descricao("Instalação de sensor de ré e câmera traseira.")
                .valorTotal(610.80)
                .status(Status.Pendente)
                .build(),

            OrdemServico.builder()
                .descricao("Substituição da embreagem e teste de rodagem.")
                .valorTotal(980.45)
                .status(Status.Concluido)
                .build()
        );

        ordemServicoRepository.saveAll(ordemServicos);

        usuarioRepository.saveAll(List.of(
                Usuario.builder()
                            .email("janunzzi26@gmail.com")
                            .password(passwordEncoder.encode("12345"))
                            .role(UsuarioRole.ADMIN)
                            .build(),
                Usuario.builder()
                            .email("pedro@gmail.com")
                            .password(passwordEncoder.encode("12345"))
                            .role(UsuarioRole.USER)
                            .build()
        ));
    }
}
