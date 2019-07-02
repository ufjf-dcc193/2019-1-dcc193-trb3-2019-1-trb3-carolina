package br.ufjf.dcc193.trabalho03.models;

/**
 * Etiqueta
 */
public class Etiqueta {
    private String titulo;
    private String descricao;
    private String url;

    public String getTitulo() {
        return titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}