package br.com.cademeurango.cade_meu_rango_api.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LivroDto {
    
    @NotBlank
    @Size(max = 100)
    private String titulo;

    @NotBlank
    @Size(max = 350)
    private String descricao;

    @NotBlank
    @Size(max = 300)
    private String image;

    @NotBlank
    @Size(max = 300)
    private String linkPdf;

    @NotBlank
    @Size(max = 80)
    private String autor;

    //Getters e setters
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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLinkPdf() {
        return this.linkPdf;
    }

    public void setLinkPdf(String linkPdf) {
        this.linkPdf = linkPdf;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
