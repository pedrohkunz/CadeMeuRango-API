package br.com.cademeurango.cade_meu_rango_api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.cademeurango.cade_meu_rango_api.model.DicaModel;
import br.com.cademeurango.cade_meu_rango_api.repository.DicasRepository;

@Service
public class DicaService {
    final DicasRepository dicasRepository;

    //Construtor
    public DicaService(DicasRepository dicasRepository) {
        this.dicasRepository = dicasRepository;
    }

    //Save
    @Transactional
    public DicaModel save(DicaModel dicaModel){
        DicaModel dica = dicasRepository.save(dicaModel);
        return dica;
    }

    //Lista todas dicas
    public List<DicaModel> findAll(){
        return dicasRepository.findAll();
    }

    //Lista as dicas pelo id
    public Optional<DicaModel> findById(int id){
        return dicasRepository.findById(id);
    }

    //Delete pelo id
    public void deleteById(int id){
        dicasRepository.deleteById(id);
    }
}
