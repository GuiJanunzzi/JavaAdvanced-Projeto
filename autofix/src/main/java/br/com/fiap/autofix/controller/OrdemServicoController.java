package br.com.fiap.autofix.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.autofix.model.OrdemServico;
import br.com.fiap.autofix.model.OrdemServicoFilter;
import br.com.fiap.autofix.repository.OrdemServicoRepository;
import br.com.fiap.autofix.specification.OrdemServicoSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Ordem de Serviço", description = "Operações relacionadas às Ordens de Serviço")
@RestController
@CrossOrigin
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private OrdemServicoRepository repository;

    //----- Documentação Swagger -----
    @Operation(
        summary = "Listar todas as Ordens de Serviço",
        description = "Retorna uma lista com todas as ordens de serviço cadastradas no sistema",
        responses = {
                @ApiResponse(responseCode = "200", description = "Lista de ordens de serviço retornada com sucesso")
        }
    )
    //----- Documentação Swagger -----
    @GetMapping
    @Cacheable("ordemServico")
    public Page<OrdemServico> index(OrdemServicoFilter filter, @PageableDefault(size = 5, sort = "valorTotal", direction = Direction.DESC) Pageable pageable){

        var specification = OrdemServicoSpecification.withFilter(filter);
        return repository.findAll(specification, pageable);
    }

    @CacheEvict(value = "ordemServico", allEntries = true)
    //----- Documentação Swagger -----
    @Operation(
        summary = "Cadastrar Ordem de Serviço",
        description = "Coleta os dados de Descrição, Valor Total e Status(Pendente, Em_Andamento, Concluido) para adicionar uma ordem de serviço no sistema",
        responses = {
                @ApiResponse(responseCode = "201", description = "Ordem de serviço criada com sucesso"),
                @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
        }
    )
    //----- Documentação Swagger -----
    @PostMapping
    public ResponseEntity<OrdemServico> create(@RequestBody @Valid OrdemServico ordemServico){
        log.info("Cadastrando Ordem de Serviço");
        repository.save(ordemServico);
        return ResponseEntity.status(210).body(ordemServico);
    }

    //----- Documentação Swagger -----
    @Operation(
        summary = "Buscar Ordem de Serviço por ID",
        description = "Retorna os dados de uma ordem de serviço com base no ID fornecido",
        responses = {
                @ApiResponse(responseCode = "200", description = "Ordem de serviço encontrada"),
                @ApiResponse(responseCode = "404", description = "Ordem de serviço não encontrada")
        }
    )
    //----- Documentação Swagger -----
    @GetMapping({"/{id}"})
    public OrdemServico get(@PathVariable Long id){
        log.info("Buscando ordem de serviço ID: " + id);
        return getOrdemServico(id);
    }

    //----- Documentação Swagger -----
    @Operation(
        summary = "Atualizar Ordem de Serviço",
        description = "Atualiza os dados de uma ordem de serviço existente com base no ID fornecido",
        responses = {
                @ApiResponse(responseCode = "200", description = "Ordem de serviço atualizada com sucesso"),
                @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
                @ApiResponse(responseCode = "404", description = "Ordem de serviço não encontrada")
        }
    )
    //----- Documentação Swagger -----
    @CacheEvict(value = "ordemServico", allEntries = true)
    @PutMapping({"/{id}"})
    public OrdemServico update(@PathVariable Long id, @RequestBody @Valid OrdemServico ordemServico){
        log.info("Atualizando ordem de serviço "+ordemServico.toString());

        getOrdemServico(id);
        ordemServico.setId(id);
        repository.save(ordemServico);

        return ordemServico;
    }

    //----- Documentação Swagger -----
    @Operation(
        summary = "Deletar Ordem de Serviço",
        description = "Remove uma ordem de serviço existente com base no ID fornecido",
        responses = {
                @ApiResponse(responseCode = "204", description = "Ordem de serviço removida com sucesso"),
                @ApiResponse(responseCode = "404", description = "Ordem de serviço não encontrada")
        }
    )
    //----- Documentação Swagger -----
    @CacheEvict(value = "ordemServico", allEntries = true)
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        log.info("Apagando Ordem de Serviço ID: " + id);
        repository.delete(getOrdemServico(id));
    }

    private OrdemServico getOrdemServico(Long id) {
        return repository
        .findById(id)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

}