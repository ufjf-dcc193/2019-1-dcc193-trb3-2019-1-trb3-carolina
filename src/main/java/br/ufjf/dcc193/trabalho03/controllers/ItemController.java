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
* ItemController
*/
@Controller
public class ItemController {
    
    private ItemRepository itemRepo;
    private EtiquetaRepository etiquetaRepo;
    
    @Autowired
    public ItemController(ItemRepository itemRepo, EtiquetaRepository etiquetaRepo) {
        this.itemRepo = itemRepo;
        this.etiquetaRepo = etiquetaRepo;
    }
    
    // CHAMA TELA CRIAR ITEM
    @RequestMapping("/item/criar.html")
    public String criar(Model model) {
        List<Etiqueta> listaEtiquetas = etiquetaRepo.findAll();
        if (listaEtiquetas != null) {
            model.addAttribute("etiquetas", listaEtiquetas);
        }
        return "/item/criar.html";
    }
    
    // CRIA ITEM
    @RequestMapping(value = "/item/criar.html", method = RequestMethod.POST)
    public String criar(Item item) {
        itemRepo.save(item);
        return "redirect:/item/listar.html";
    }
    
    // LISTA ITENS
    @RequestMapping("/item/listar.html")
    public String listar(Model model) {
        List<Item> listaItens = itemRepo.findAll();
        if (listaItens != null) {
            model.addAttribute("itens", listaItens);
        }
        return "item/listar.html";
    }
    
    //CHAMA A TELA EDITAR ITEM
    @RequestMapping(value = "/item/editar.html/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Item item = itemRepo.findById(id).get();
        List<Etiqueta> listaEtiquetas = etiquetaRepo.findAll();
        if (listaEtiquetas != null) {
            model.addAttribute("etiquetas", listaEtiquetas);
        }
        model.addAttribute("item", item);
        return "/item/editar.html";
    }
    
    //CHAMA A TELA DETALHAR ITEM
    @RequestMapping(value = "/item/detalhar.html/{id}")
    public String detalhar(@PathVariable("id") Long id, Model model) {
        Item item = itemRepo.findById(id).get();
        model.addAttribute("item", item);
        return "/item/detalhar.html";
    }
    
    //EDITA ITEM
    @RequestMapping(value = "/item/editar.html/{id}", method = RequestMethod.POST)
    public String editar(Item item) {
        itemRepo.save(item);
        return "redirect:/item/listar.html";
    }
    
    //DELETA ITEM
    @RequestMapping(value = "/item/deletar.html/{id}")
    public String deletar(@PathVariable("id") Long id) {
        itemRepo.deleteById(id);
        return "redirect:/item/listar.html";
    }
}