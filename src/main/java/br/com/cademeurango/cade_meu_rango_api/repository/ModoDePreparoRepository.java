package br.com.cademeurango.cade_meu_rango_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cademeurango.cade_meu_rango_api.model.ModoDePreparoModel;
import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;

//Repositório de Modos de preparos
public interface ModoDePreparoRepository extends JpaRepository<ModoDePreparoModel, Integer>{

    List<ModoDePreparoModel> findByReceita(ReceitaModel receita);
    
}
