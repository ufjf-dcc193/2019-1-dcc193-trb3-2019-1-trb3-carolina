package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Vinculo
 */
@Entity
public class Vinculo {
    @Id
    @GeneratedValue
    private int id;
    private int itemOrigem;
    private int itemDestino;
    private List<Integer> anotacoes;
    private List<Integer> etiquetas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemOrigem() {
        return itemOrigem;
    }

    public void setItemOrigem(int itemOrigem) {
        this.itemOrigem = itemOrigem;
    }

    public int getItemDestino() {
        return itemDestino;
    }

    public void setItemDestino(int itemDestino) {
        this.itemDestino = itemDestino;
    }

    public List<Integer> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Integer> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public List<Integer> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Integer> etiquetas) {
        this.etiquetas = etiquetas;
    }
}