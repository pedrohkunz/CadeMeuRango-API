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
@Table(name = "ingredientes")
public class IngredienteModel implements Serializable{

    //Chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Atributos
    @Column(nullable = false, length = 45)
    private String nome;

    @Column(nullable = false, length = 45)
    private String quantidade;

    @Column(nullable = false)
    private byte posicao;

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

    public ReceitaModel getReceita() {
        return this.receita;
    }

    public void setReceita(ReceitaModel receita) {
        this.receita = receita;
    }

}
