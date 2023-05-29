package br.com.cademeurango.cade_meu_rango_api.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dicas_culinarias")
public class DicaModel implements Serializable{

    //Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Atributos
    @Column(nullable = false, length = 80)
    private String titulo;

    @Column(nullable = false, length = 800)
    private String descricao;

    @Column(nullable = false)
    private LocalDate data;

    //Getters e Setters

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

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    

}
