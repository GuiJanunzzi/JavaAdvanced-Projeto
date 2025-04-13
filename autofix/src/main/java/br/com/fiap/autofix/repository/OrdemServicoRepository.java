package br.com.fiap.autofix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.autofix.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    
}
