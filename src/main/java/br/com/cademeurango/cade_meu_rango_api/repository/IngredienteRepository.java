package br.com.cademeurango.cade_meu_rango_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cademeurango.cade_meu_rango_api.model.IngredienteModel;
import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;

//Repositório de ingredientes
public interface IngredienteRepository extends JpaRepository<IngredienteModel, Integer>{

    List<IngredienteModel> findByReceita(ReceitaModel receita);
    
}
