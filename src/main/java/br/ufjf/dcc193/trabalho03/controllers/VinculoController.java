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
    public VinculoController(VinculoRepository vinculoRepo, ItemRepository itemRepo, EtiquetaRepository etiquetaRepo) {
        this.vinculoRepo = vinculoRepo;
        this.itemRepo = itemRepo;
        this.etiquetaRepo = etiquetaRepo;
    }
    
    // CHAMA TELA CRIA VINCULO
    @RequestMapping("/vinculo/criar.html/{id}")
    public String criar(@PathVariable("id") Long id, Model model) {
        Item item = itemRepo.findById(id).get();
        model.addAttribute("item", item);
        List<Item> listaItens = itemRepo.findAll();
        if (listaItens != null) {
            model.addAttribute("itens", listaItens);
        }
        List<Etiqueta> listaEtiquetas = etiquetaRepo.findAll();
        if (listaEtiquetas != null) {
            model.addAttribute("etiquetas", listaEtiquetas);
        }
        return "/vinculo/criar.html";
    }
    
    // CRIA VINCULO
    @RequestMapping(value = "/vinculo/criar.html/{id}", method = RequestMethod.POST)
    public String criar(Vinculo vinculo) {
        vinculoRepo.save(vinculo);
        return "redirect:/vinculo/listar.html";
    }
    
    // LISTA VINCULOS
    @RequestMapping("/vinculo/listar.html")
    public String listar(Model model) {
        List<Vinculo> listaVinculos = vinculoRepo.findAll();
        if (listaVinculos != null) {
            model.addAttribute("vinculos", listaVinculos);
        }
        return "/vinculo/listar.html";
    }
    
    // CHAMA TELA EDITAR VINCULO
    @RequestMapping("/vinculo/editar.html/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Vinculo vinculo = vinculoRepo.findById(id).get();
        model.addAttribute("vinculo", vinculo);
        List<Item> listaItens = itemRepo.findAll();
        if (listaItens != null) {
            model.addAttribute("itens", listaItens);
        }
        List<Etiqueta> listaEtiquetas = etiquetaRepo.findAll();
        if (listaEtiquetas != null) {
            model.addAttribute("etiquetas", listaEtiquetas);
        }
        return "/vinculo/editar.html";
    }
    
    //CHAMA A TELA DETALHAR VINCULO
    @RequestMapping(value = "/vinculo/detalhar.html/{id}")
    public String detalhar(@PathVariable("id") Long id, Model model) {
        Vinculo vinculo = vinculoRepo.findById(id).get();
        model.addAttribute("vinculo", vinculo);
        return "/vinculo/detalhar.html";
    }
    
    //DELETA VINCULO
    @RequestMapping(value = "/vinculo/deletar.html/{id}")
    public String deletar(@PathVariable("id") Long id) {
        vinculoRepo.deleteById(id);
        return "redirect:/vinculo/listar.html";
    }
}