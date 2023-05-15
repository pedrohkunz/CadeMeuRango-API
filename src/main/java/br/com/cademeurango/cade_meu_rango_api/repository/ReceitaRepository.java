package br.com.cademeurango.cade_meu_rango_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Integer>{
    
}
