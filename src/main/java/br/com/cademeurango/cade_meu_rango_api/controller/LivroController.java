package br.com.cademeurango.cade_meu_rango_api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cademeurango.cade_meu_rango_api.dtos.LivroDto;
import br.com.cademeurango.cade_meu_rango_api.model.ErrorModel;
import br.com.cademeurango.cade_meu_rango_api.model.LivroModel;
import br.com.cademeurango.cade_meu_rango_api.service.LivroService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livros")
public class LivroController {

    final LivroService livroService;

    //Construtor
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }


    @PostMapping
    public ResponseEntity<Object> saveLivro(@RequestBody @Valid LivroDto livroDto){
        var livroModel = new LivroModel();
        BeanUtils.copyProperties(livroDto, livroModel);

        LivroModel savedLivro = livroService.save(livroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLivro);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>>getAllLivros(){
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLivroById(@PathVariable int id){
        Optional<LivroModel> livro = livroService.findById(id);
        ErrorModel isNull = new ErrorModel("Este livro não existe!");
            if(livro.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(livro);
            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isNull);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<LivroModel> livro = livroService.findById(id);
        ErrorModel vazio = new ErrorModel("Este livro não existe!");
        if (livro.isPresent()) {
            livroService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Livro excluido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vazio);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid LivroDto livroDto) {
        Optional<LivroModel> livroOptional = livroService.findById(id);
        ErrorModel vazio = new ErrorModel("Este livro não existe!");
        
        if (!livroOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vazio);
        } else {
            LivroModel livroModel = livroOptional.get();
            livroModel.setTitulo(livroDto.getTitulo());
            livroModel.setDescricao(livroDto.getDescricao());
            livroModel.setImage(livroDto.getImage());
            livroModel.setLinkPdf(livroDto.getLinkPdf());
            livroModel.setAutor(livroDto.getAutor());
            
            return ResponseEntity.status(HttpStatus.OK).body(livroService.save(livroModel));
        }
    }

}
