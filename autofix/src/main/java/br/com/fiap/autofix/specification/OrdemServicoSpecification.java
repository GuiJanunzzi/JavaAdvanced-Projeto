package br.com.fiap.autofix.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import br.com.fiap.autofix.model.OrdemServico;
import br.com.fiap.autofix.model.OrdemServicoFilter;
import jakarta.persistence.criteria.Predicate;

public class OrdemServicoSpecification {
    public static Specification<OrdemServico> withFilter(OrdemServicoFilter filter){
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(filter.status() != null){
                predicates.add(cb.equal(root.get("status"), filter.status()));
            }

            if(filter.valorMin() != null && filter.valorMax() != null){
                predicates.add(cb.between(root.get("valorTotal"), filter.valorMin(), filter.valorMax()));
            }else if(filter.valorMin() != null){
                predicates.add(cb.greaterThanOrEqualTo(root.get("valorTotal"), filter.valorMin()));
            }else if(filter.valorMax() != null){
                predicates.add(cb.lessThanOrEqualTo(root.get("valorTotal"), filter.valorMax()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
