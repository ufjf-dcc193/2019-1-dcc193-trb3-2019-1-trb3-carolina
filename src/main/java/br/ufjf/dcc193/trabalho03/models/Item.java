package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Item
 */
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    // @OneToMany
    // private List<Anotacao> anotacoes;
    @ManyToMany
    private List<Etiqueta> etiquetas;
    
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

    // public List<Anotacao> getAnotacoes() {
    //     return anotacoes;
    // }

    // public void setAnotacoes(List<Anotacao> anotacoes) {
    //     this.anotacoes = anotacoes;
    // }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}