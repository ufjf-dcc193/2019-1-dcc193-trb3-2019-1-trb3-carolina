package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Vinculo
 */
@Entity
public class Vinculo {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Item origem;
    @ManyToOne
    private Item destino;
    @ManyToMany
    private List<Etiqueta> etiquetas;
 
    // @OneToMany
    // private List<Anotacao> anotacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getOrigem() {
        return origem;
    }

    public void setOrigem(Item origem) {
        this.origem = origem;
    }

    public Item getDestino() {
        return destino;
    }

    public void setDestino(Item destino) {
        this.destino = destino;
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