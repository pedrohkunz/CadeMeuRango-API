package br.com.cademeurango.cade_meu_rango_api.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cademeurango.cade_meu_rango_api.dtos.ReceitaDto;
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
    public ResponseEntity<Object> saveReceita(@RequestBody @Valid ReceitaDto receitaDto){
        var receitaModel = new ReceitaModel();
        BeanUtils.copyProperties(receitaDto, receitaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(receitaService.save(receitaModel));
    } 
}
