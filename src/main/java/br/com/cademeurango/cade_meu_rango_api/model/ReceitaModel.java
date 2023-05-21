package br.com.cademeurango.cade_meu_rango_api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "receitas")
public class ReceitaModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 45)
    private String titulo;

    @Column(nullable = false, length = 450)
    private String descricao;

    @Column(nullable = false, length = 300)
    private String imagem;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<IngredienteModel> ingredientes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<ModoDePreparoModel> modoDePreparo;

    
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

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<IngredienteModel> getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(List<IngredienteModel> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<ModoDePreparoModel> getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(List<ModoDePreparoModel> modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }
    
}
