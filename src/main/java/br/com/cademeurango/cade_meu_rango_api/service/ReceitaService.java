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

    //Construtor
    public ReceitaService(ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository, ModoDePreparoRepository modoDePreparoRepository) {
        this.receitaRepository = receitaRepository;
        this.ingredienteRepository = ingredienteRepository;
        this.modoDePreparoRepository = modoDePreparoRepository;
    }
    
    //Regras de negócios das requisições POST e PUT
    @Transactional
    public ReceitaModel save(ReceitaModel receitaModel) {
        ReceitaModel receita = receitaRepository.save(receitaModel);
    
        // Exclui os ingredientes antigos
        List<IngredienteModel> ingredientes = receitaModel.getIngredientes();
        List<IngredienteModel> ingredientesAntigos = ingredienteRepository.findByReceita(receita);
        for (IngredienteModel ingredienteAntigo : ingredientesAntigos) {
            if (!ingredientes.contains(ingredienteAntigo)) {
                ingredienteRepository.deleteById(ingredienteAntigo.getId());
            }
        }
    
        // Atualiza os ingredientes
        for(IngredienteModel ingrediente : ingredientes){
            ingrediente.setReceita(receita);
        }
        ingredienteRepository.saveAll(ingredientes);
    

        // Exclui os modos de preparo
        List<ModoDePreparoModel> modosDePreparos = receitaModel.getModoDePreparo();
        List<ModoDePreparoModel> modosDePreparoAntigos = modoDePreparoRepository.findByReceita(receita);
        for(ModoDePreparoModel modoDePreparoAntigo : modosDePreparoAntigos){
            if(!modosDePreparos.contains(modoDePreparoAntigo)) {
                modoDePreparoRepository.deleteById(modoDePreparoAntigo.getId());
            }
        }

        // Atualiza os modos de preparo
        for(ModoDePreparoModel modoDePreparo : modosDePreparos){
            modoDePreparo.setReceita(receita);
        }
        modoDePreparoRepository.saveAll(modosDePreparos);
    
        return receita;
    }

    //Lista todas receitas via GET
    public List<ReceitaModel> findAll() {
        return receitaRepository.findAll();
    }

    //Retorna uma receita pelo ID via GET
    public Optional<ReceitaModel> findById(int id){
        return receitaRepository.findById(id);
    }

    //Deleta uma receita com base no ID
    public void deleteById(int id) {
        receitaRepository.deleteById(id);
    }

    

}