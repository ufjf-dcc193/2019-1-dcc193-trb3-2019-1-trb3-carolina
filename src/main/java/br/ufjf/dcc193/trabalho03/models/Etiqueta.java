package br.ufjf.dcc193.trabalho03.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


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

    // public void setItems(List<Item> itens) {
    //     this.itens = itens;
    // }
    
}