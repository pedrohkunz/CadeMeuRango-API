package br.com.cademeurango.cade_meu_rango_api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livros_de_receitas")
public class LivroModel implements Serializable{
    
    //Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Atributos

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 350)
    private String descricao;

    @Column(nullable = false, length = 300)
    private String image;

    @Column(nullable = false, length = 300)
    private String linkPdf;

    @Column(nullable = false, length = 80)
    private String autor;

    //Getters e setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


