package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

/**
 * Item
 */
public class Item {
    private String título;
    private List<Integer> anotacoes;
    private List<Integer> etiquetas;
    private List<Integer> vinculos;

    public String getTítulo() {
        return título;
    }

    public List<Integer> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Integer> vinculos) {
        this.vinculos = vinculos;
    }

    public List<Integer> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Integer> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public List<Integer> getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(List<Integer> anotacoes) {
        this.anotacoes = anotacoes;
    }

    public void setTítulo(String título) {
        this.título = título;
    }
}