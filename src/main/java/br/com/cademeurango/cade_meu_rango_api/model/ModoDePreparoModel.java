package br.com.cademeurango.cade_meu_rango_api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "modo_de_preparo")
public class ModoDePreparoModel implements Serializable{
    
    //Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Atributo
    @Column(nullable = false, length = 250)
    private String descricao;

    //Chave estrangeira
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "receita_id")
    private ReceitaModel receita;


    //Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ReceitaModel getReceita() {
        return this.receita;
    }

    public void setReceita(ReceitaModel receita) {
        this.receita = receita;
    }

}
