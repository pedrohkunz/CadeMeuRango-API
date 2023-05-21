package br.com.cademeurango.cade_meu_rango_api.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ModoDePreparoDto {
    
    //Atributo
    @NotBlank
    @Size(max = 250)
    private String descricao;


    //Getters e Setters
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
