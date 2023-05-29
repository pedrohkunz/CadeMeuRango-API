package br.com.cademeurango.cade_meu_rango_api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.cademeurango.cade_meu_rango_api.model.LivroModel;
import br.com.cademeurango.cade_meu_rango_api.repository.LivroRepository;

@Service
public class LivroService {
    final LivroRepository livroRepository;

    //Construtor
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //Save
    @Transactional
    public LivroModel save(LivroModel livroModel){
        LivroModel livro = livroRepository.save(livroModel);
        return livro;
    }

     //Lista todos os livros
     public List<LivroModel> findAll(){
        return livroRepository.findAll();
    }

     //Lista os livros pelo id
     public Optional<LivroModel> findById(int id){
        return livroRepository.findById(id);
    }

    //Delete pelo id
    public void deleteById(int id){
        livroRepository.deleteById(id);
    }

}
