package br.ufjf.dcc193.trabalho03.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufjf.dcc193.trabalho03.models.Etiqueta;
import br.ufjf.dcc193.trabalho03.models.Item;
import br.ufjf.dcc193.trabalho03.models.Vinculo;
import br.ufjf.dcc193.trabalho03.repositorys.EtiquetaRepository;
import br.ufjf.dcc193.trabalho03.repositorys.ItemRepository;
import br.ufjf.dcc193.trabalho03.repositorys.VinculoRepository;

/**
 * VinculoController
 */
@Controller
public class VinculoController {
    
    private VinculoRepository vinculoRepo;
    private ItemRepository itemRepo;
    private EtiquetaRepository etiquetaRepo;

    @Autowired
    public VinculoController(VinculoRepository vinculoRepo) {
        this.vinculoRepo = vinculoRepo;
    }

    // CHAMA TELA CRIA VINCULO
    @RequestMapping("/vinculo/criar.html/{id}")
    public String criar(@PathVariable("id") Long id, Model model) {
        List<Etiqueta> listaEtiquetas = etiquetaRepo.findAll();
        if (listaEtiquetas != null) {
            model.addAttribute("etiquetas", listaEtiquetas);
        }
        Item item = itemRepo.findById(id).get();
        model.addAttribute("item", item);
        return "/vinculo/criar.html";
    }
    
    // CRIA VINCULO
    @RequestMapping(value = "/vinculo/criar.html", method = RequestMethod.POST)
    public String criar(Vinculo vinculo) {
        vinculoRepo.save(vinculo);
        return "redirect:/vinculo/listar.html";
    }
}