package br.com.cademeurango.cade_meu_rango_api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;

@Repository
public interface ReceitaRepository extends JpaRepository<ReceitaModel, UUID>{
    
}
