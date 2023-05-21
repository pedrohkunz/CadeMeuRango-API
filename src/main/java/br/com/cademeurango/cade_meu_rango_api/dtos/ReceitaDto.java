package br.com.cademeurango.cade_meu_rango_api.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ReceitaDto {
    
    @NotBlank
    @Size(max = 60)
    private String titulo;

    @NotBlank
    @Size(max = 450)
    private String descricao;

    @NotBlank
    @Size(max = 300)
    private String imagem;

    @NotEmpty
    private List<IngredienteDto> ingredientes;

    @NotEmpty
    private List<ModoDePreparoDto> modoDePreparo;

   
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

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<IngredienteDto> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(List<IngredienteDto> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<ModoDePreparoDto> getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(List<ModoDePreparoDto> modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

}
