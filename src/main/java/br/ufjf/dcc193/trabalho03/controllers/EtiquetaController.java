package br.ufjf.dcc193.trabalho03.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufjf.dcc193.trabalho03.models.Etiqueta;
import br.ufjf.dcc193.trabalho03.repositorys.EtiquetaRepository;

/**
 * EtiquetaController
 */
@Controller
public class EtiquetaController {

    private EtiquetaRepository etiquetaRepo;

    @Autowired
    public EtiquetaController(EtiquetaRepository etiquetaRepo) {
        this.etiquetaRepo = etiquetaRepo;
    }

    // CHAMA TELA CRIAR ETIQUETA
    @RequestMapping("/etiqueta/criar.html")
    public String criar() {
        return "/etiqueta/criar.html";
    }

    // CRIA ETIQUETA
    @RequestMapping(value = "/etiqueta/criar.html", method = RequestMethod.POST)
    public String criar(Etiqueta etiqueta) {
        etiquetaRepo.save(etiqueta);
        return "redirect:/etiqueta/listar.html";
    }

    // LISTA ETIQUETAS
    @RequestMapping("/etiqueta/listar.html")
    public String listar(Model model) {
        List<Etiqueta> listaEtiquetas = etiquetaRepo.findAll();
        if (listaEtiquetas != null) {
            model.addAttribute("etiquetas", listaEtiquetas);
        }
        return "etiqueta/listar.html";
    }

    //CHAMA A TELA EDITAR ETIQUETA
    @RequestMapping(value = "/etiqueta/editar.html/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Etiqueta etiqueta = etiquetaRepo.findById(id).get();
        model.addAttribute("etiqueta", etiqueta);
        return "/etiqueta/editar.html";
    }

    //EDITA ETIQUETA
    @RequestMapping(value = "/etiqueta/editar.html/{id}", method = RequestMethod.POST)
    public String editar(Etiqueta etiqueta) {
        etiquetaRepo.save(etiqueta);
        return "redirect:/etiqueta/listar.html";
    }

    //DELETA ETIQUETA
    @RequestMapping(value = "/etiqueta/deletar.html/{id}")
    public String deletar(@PathVariable("id") Long id) {
        etiquetaRepo.deleteById(id);
        return "redirect:/etiqueta/listar.html";
    }
}