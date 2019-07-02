// package br.ufjf.dcc193.trabalho03.models;

// import java.util.List;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.OneToMany;

// /**
//  * Vinculo
//  */
// @Entity
// public class Vinculo {
//     @Id
//     @GeneratedValue
//     private Long id;
//     private int itemOrigem;
//     private int itemDestino;
//     @OneToMany
//     private List<Anotacao> anotacoes;
//     @OneToMany
//     private List<Etiqueta> etiquetas;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public int getItemOrigem() {
//         return itemOrigem;
//     }

//     public void setItemOrigem(int itemOrigem) {
//         this.itemOrigem = itemOrigem;
//     }

//     public int getItemDestino() {
//         return itemDestino;
//     }

//     public void setItemDestino(int itemDestino) {
//         this.itemDestino = itemDestino;
//     }

//     public List<Anotacao> getAnotacoes() {
//         return anotacoes;
//     }

//     public void setAnotacoes(List<Anotacao> anotacoes) {
//         this.anotacoes = anotacoes;
//     }

//     public List<Etiqueta> getEtiquetas() {
//         return etiquetas;
//     }

//     public void setEtiquetas(List<Etiqueta> etiquetas) {
//         this.etiquetas = etiquetas;
//     }
// }