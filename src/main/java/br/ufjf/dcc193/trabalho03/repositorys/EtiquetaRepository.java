package br.ufjf.dcc193.trabalho03.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufjf.dcc193.trabalho03.models.Etiqueta;

/**
 * EtiquetaRepository
 */
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
    List<Etiqueta> findAll();
    void deleteById(Long Id);
}