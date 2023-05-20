package br.com.cademeurango.cade_meu_rango_api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.cademeurango.cade_meu_rango_api.model.IngredienteModel;
import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;
import br.com.cademeurango.cade_meu_rango_api.repository.IngredienteRepository;
import br.com.cademeurango.cade_meu_rango_api.repository.ReceitaRepository;

@Service
public class ReceitaService {

    final ReceitaRepository receitaRepository;
    final IngredienteRepository ingredienteRepository;


    public ReceitaService(ReceitaRepository receitaRepository, IngredienteRepository ingredienteRepository) {
        this.receitaRepository = receitaRepository;
        this.ingredienteRepository = ingredienteRepository;
    }
    

    @Transactional
    //public ReceitaModel save(ReceitaModel receitaModel) {
   //     return receitaRepository.save(receitaModel);
   // }
   public ReceitaModel save(ReceitaModel receitaModel) {
    // Salvar a receita primeiro para gerar o ID
    ReceitaModel receita = receitaRepository.save(receitaModel);

    // Definir a referência à receita para cada ingrediente
    List<IngredienteModel> ingredientes = receitaModel.getIngredientes();
    for (IngredienteModel ingrediente : ingredientes) {
        ingrediente.setReceita(receita);
    }

    // Salvar os ingredientes
    ingredienteRepository.saveAll(ingredientes);

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
