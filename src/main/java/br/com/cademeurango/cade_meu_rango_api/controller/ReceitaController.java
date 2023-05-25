package br.com.cademeurango.cade_meu_rango_api.controller;

import java.util.ArrayList;
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

import br.com.cademeurango.cade_meu_rango_api.dtos.IngredienteDto;
import br.com.cademeurango.cade_meu_rango_api.dtos.ModoDePreparoDto;
import br.com.cademeurango.cade_meu_rango_api.dtos.ReceitaDto;
import br.com.cademeurango.cade_meu_rango_api.model.ErrorModel;
import br.com.cademeurango.cade_meu_rango_api.model.IngredienteModel;
import br.com.cademeurango.cade_meu_rango_api.model.ModoDePreparoModel;
import br.com.cademeurango.cade_meu_rango_api.model.ReceitaModel;
import br.com.cademeurango.cade_meu_rango_api.service.ReceitaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/receitas")
public class ReceitaController {
    
    final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }


    @PostMapping
    public ResponseEntity<Object> saveReceita(@RequestBody @Valid ReceitaDto receitaDto) {
        var receitaModel = new ReceitaModel();
        BeanUtils.copyProperties(receitaDto, receitaModel);

        //Armazena os ingredientes
        List<IngredienteModel> ingredientesModel = new ArrayList<>();
            for (IngredienteDto ingredienteDto : receitaDto.getIngredientes()) {
                var ingredienteModel = new IngredienteModel();
                BeanUtils.copyProperties(ingredienteDto, ingredienteModel);
                ingredientesModel.add(ingredienteModel);
            }
        receitaModel.setIngredientes(ingredientesModel);

        //Armazena os modos de preparo
        List<ModoDePreparoModel> modoDePreparoModel = new ArrayList<>();
            for (ModoDePreparoDto modoDePreparoDto : receitaDto.getModoDePreparo()) {
                var preparo = new ModoDePreparoModel();
                BeanUtils.copyProperties(modoDePreparoDto, preparo);
                modoDePreparoModel.add(preparo);
            }
        receitaModel.setModoDePreparo(modoDePreparoModel);
        
        ReceitaModel savedReceita = receitaService.save(receitaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReceita);
    }


    @GetMapping
    public ResponseEntity<List<ReceitaModel>>getAllReceitas(){
        return ResponseEntity.status(HttpStatus.OK).body(receitaService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getReceitaById(@PathVariable int id){
        Optional<ReceitaModel> receita = receitaService.findById(id);
        ErrorModel isNull = new ErrorModel("Esta receita não existe!");
            if(receita.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(receita);
            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isNull);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<ReceitaModel> receita = receitaService.findById(id);
        ErrorModel vazio = new ErrorModel("Esta receita não existe!");
        if (receita.isPresent()) {
            receitaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Receita excluída com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vazio);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid ReceitaDto receitaDto) {
        Optional<ReceitaModel> receitaOptional = receitaService.findById(id);
        ErrorModel vazio = new ErrorModel("Esta receita não existe!");
        
        if (!receitaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vazio);
        } else {
            ReceitaModel receitaModel = receitaOptional.get();
            receitaModel.setTitulo(receitaDto.getTitulo());
            receitaModel.setDescricao(receitaDto.getDescricao());
            receitaModel.setImagem(receitaDto.getImagem());
            
            receitaService.deleteIngredientes(receitaModel.getIngredientes());
            
            //Armazena os ingredientes
            List<IngredienteModel> ingredientesModels = new ArrayList<>();
            for (IngredienteDto ingredienteDto : receitaDto.getIngredientes()) {
                IngredienteModel ingredienteModel = new IngredienteModel();
                BeanUtils.copyProperties(ingredienteDto, ingredienteModel);
                ingredientesModels.add(ingredienteModel);
            }
            receitaModel.setIngredientes(ingredientesModels);
            
            //Armazena os modos de preparo
            List<ModoDePreparoModel> modoDePreparoModels = new ArrayList<>();
            for (ModoDePreparoDto modoDePreparoDto : receitaDto.getModoDePreparo()) {
                ModoDePreparoModel modoDePreparoModel = new ModoDePreparoModel();
                BeanUtils.copyProperties(modoDePreparoDto, modoDePreparoModel);
                modoDePreparoModels.add(modoDePreparoModel);
            }
            receitaModel.setModoDePreparo(modoDePreparoModels);
            
            return ResponseEntity.status(HttpStatus.OK).body(receitaService.save(receitaModel));
        }
    }
    
}

