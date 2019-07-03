package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * Vinculo
 */
@Entity
public class Vinculo {
    @Id
    @GeneratedValue
    private Long id;
 
    @OneToOne(fetch = FetchType.EAGER)
    private Item itemOrigem;
 
    @OneToOne(fetch = FetchType.EAGER)
    private Item itemDestino;
 
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

    public Item getItemOrigem() {
        return itemOrigem;
    }

    public void setItemOrigem(Item itemOrigem) {
        this.itemOrigem = itemOrigem;
    }

    public Item getItemDestino() {
        return itemDestino;
    }

    public void setItemDestino(Item itemDestino) {
        this.itemDestino = itemDestino;
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