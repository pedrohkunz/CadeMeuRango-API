package br.com.cademeurango.cade_meu_rango_api.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DicaDto {

    @NotBlank
    @Size(max = 80)
    private String titulo;

    @NotBlank
    @Size(max = 800)
    private String descricao;


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
