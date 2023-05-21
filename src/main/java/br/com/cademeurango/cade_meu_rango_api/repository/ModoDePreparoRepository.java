package br.com.cademeurango.cade_meu_rango_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cademeurango.cade_meu_rango_api.model.ModoDePreparoModel;

//Repositório de Modos de preparos
public interface ModoDePreparoRepository extends JpaRepository<ModoDePreparoModel, Integer>{
    
}
