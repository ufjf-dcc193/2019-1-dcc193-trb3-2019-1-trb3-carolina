package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Item
 */
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String título;
    // @OneToMany
    // private List<Anotacao> anotacoes;
    @OneToMany
    private List<Etiqueta> etiquetas;
    // @OneToMany
    // private List<Vinculo> vinculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
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

    // public List<Vinculo> getVinculos() {
    //     return vinculos;
    // }

    // public void setVinculos(List<Vinculo> vinculos) {
    //     this.vinculos = vinculos;
    // }
}