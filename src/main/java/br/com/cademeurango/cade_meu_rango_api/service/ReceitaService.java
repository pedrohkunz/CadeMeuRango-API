package br.com.cademeurango.cade_meu_rango_api.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;
import br.com.cademeurango.cade_meu_rango_api.repository.ReceitaRepository;

@Service
public class ReceitaService {

    final ReceitaRepository receitaRepository;

    public ReceitaService(ReceitaRepository receitaRepository){
        this.receitaRepository = receitaRepository;
    }

    @Transactional
    public ReceitaModel save(ReceitaModel receitaModel) {
        return receitaRepository.save(receitaModel);
    }
}
