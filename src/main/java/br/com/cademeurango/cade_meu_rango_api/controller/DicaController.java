package br.com.cademeurango.cade_meu_rango_api.controller;

import java.time.LocalDate;
import java.time.ZoneId;
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

import br.com.cademeurango.cade_meu_rango_api.dtos.DicaDto;
import br.com.cademeurango.cade_meu_rango_api.model.DicaModel;
import br.com.cademeurango.cade_meu_rango_api.model.ErrorModel;
import br.com.cademeurango.cade_meu_rango_api.service.DicaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/dicas")
public class DicaController {
    
    final DicaService dicaService;

    public DicaController(DicaService dicaService) {
        this.dicaService = dicaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDica(@RequestBody @Valid DicaDto dicaDto){
        var dicaModel = new DicaModel();
        BeanUtils.copyProperties(dicaDto, dicaModel);
        dicaModel.setData(LocalDate.now(ZoneId.of("UTC")));
        DicaModel savedDica = dicaService.save(dicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDica);
    }

    @GetMapping
    public ResponseEntity<List<DicaModel>>getAllDicas(){
        return ResponseEntity.status(HttpStatus.OK).body(dicaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDicaById(@PathVariable int id){
        Optional<DicaModel> dica = dicaService.findById(id);
        ErrorModel isNull = new ErrorModel("Esta dica não existe!");
            if(dica.isPresent()){
                return ResponseEntity.status(HttpStatus.OK).body(dica);
            } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isNull);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<DicaModel> dica = dicaService.findById(id);
        ErrorModel vazio = new ErrorModel("Esta dica não existe!");
        if (dica.isPresent()) {
            dicaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Dica excluída com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vazio);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid DicaDto dicaDto) {
        Optional<DicaModel> dicaOptional = dicaService.findById(id);
        ErrorModel vazio = new ErrorModel("Esta dica não existe!");
        
        if (!dicaOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vazio);
        } else {
            DicaModel dicaModel = dicaOptional.get();
            dicaModel.setTitulo(dicaDto.getTitulo());
            dicaModel.setDescricao(dicaDto.getDescricao());
            
            return ResponseEntity.status(HttpStatus.OK).body(dicaService.save(dicaModel));
        }
    }

}
