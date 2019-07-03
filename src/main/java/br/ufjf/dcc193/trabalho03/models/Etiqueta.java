package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 * Etiqueta
 */
@Entity
public class Etiqueta {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    @ManyToMany
    private List<Vinculo> vinculos;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // public List<Item> getItens() {
    //     return itens;
    // }

    // public void setItens(List<Item> itens) {
    //     this.itens = itens;
    // }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }
    
}