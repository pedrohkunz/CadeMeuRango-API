package br.com.cademeurango.cade_meu_rango_api.service;

import java.util.List;
import java.util.Optional;

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

    public List<ReceitaModel> findAll() {
        return receitaRepository.findAll();
    }

    public Optional<ReceitaModel> findById(int id){
        return receitaRepository.findById(id);
    }

    public void deleteById(int id) {
        receitaRepository.deleteById(id);
    }


}
