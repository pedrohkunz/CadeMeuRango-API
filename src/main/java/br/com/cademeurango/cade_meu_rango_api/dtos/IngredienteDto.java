package br.com.cademeurango.cade_meu_rango_api.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class IngredienteDto {

    //Atributos
    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Size(max = 60)
    private String quantidade;

    @NotBlank
    private byte posicao;


    //Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public byte getPosicao() {
        return this.posicao;
    }

    public void setPosicao(byte posicao) {
        this.posicao = posicao;
    }

}
