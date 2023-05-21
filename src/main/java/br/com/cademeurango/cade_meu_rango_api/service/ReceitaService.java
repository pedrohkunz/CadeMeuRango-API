package br.com.cademeurango.cade_meu_rango_api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.cademeurango.cade_meu_rango_api.model.IngredienteModel;
import br.com.cademeurango.cade_meu_rango_api.model.ModoDePreparoModel;
import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;
import br.com.cademeurango.cade_meu_rango_api.repository.IngredienteRepository;
import br.com.cademeurango.cade_meu_rango_api.repository.ModoDePreparoRepository;
import br.com.cademeurango.cade_meu_rango_api.repository.ReceitaRepository;

@Service
public class ReceitaService {

    final ReceitaRepository receitaRepository;
    final IngredienteRepository ingredienteRepository;
    final ModoDePreparoRepository modoDePreparoRepository;


    public ReceitaService(ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository, ModoDePreparoRepository modoDePreparoRepository) {
        this.receitaRepository = receitaRepository;
        this.ingredienteRepository = ingredienteRepository;
        this.modoDePreparoRepository = modoDePreparoRepository;
    }
    
    @Transactional
    public ReceitaModel save(ReceitaModel receitaModel) {
        ReceitaModel receita = receitaRepository.save(receitaModel);
    
        // Armazena ingredientes
        List<IngredienteModel> ingredientes = receitaModel.getIngredientes();
            for (IngredienteModel ingrediente : ingredientes) {
                ingrediente.setReceita(receita);
            }
            ingredienteRepository.saveAll(ingredientes);
    
        // Armazena ModoDePreparo
        List<ModoDePreparoModel> modoDePreparo = receitaModel.getModoDePreparo();
            for (ModoDePreparoModel preparo : modoDePreparo) {
                preparo.setReceita(receita);
            }
            modoDePreparoRepository.saveAll(modoDePreparo);
    
        return receita;
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