package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Item
 */
@Entity
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String título;
    private List<Integer> anotacoes;
    private List<Integer> etiquetas;
    private List<Integer> vinculos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
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

    public List<Integer> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Integer> vinculos) {
        this.vinculos = vinculos;
    }
}