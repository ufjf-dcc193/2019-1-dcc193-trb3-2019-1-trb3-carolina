package br.ufjf.dcc193.trabalho03.models;

import java.util.List;

/**
 * Vinculo
 */
public class Vinculo {
    private int itemOrigem;
    private int itemDestino;
    private List<Integer> anotacoes;
    private List<Integer> etiquetas;

    public int getItemOrigem() {
        return itemOrigem;
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

    public int getItemDestino() {
        return itemDestino;
    }

    public void setItemDestino(int itemDestino) {
        this.itemDestino = itemDestino;
    }

    public void setItemOrigem(int itemOrigem) {
        this.itemOrigem = itemOrigem;
    }
}