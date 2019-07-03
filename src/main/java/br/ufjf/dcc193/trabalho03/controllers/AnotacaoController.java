package br.ufjf.dcc193.trabalho03.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufjf.dcc193.trabalho03.models.Anotacao;
import br.ufjf.dcc193.trabalho03.models.Usuario;
import br.ufjf.dcc193.trabalho03.repositorys.AnotacaoRepository;

/**
 * AnotacaoController
 */
@Controller
public class AnotacaoController {

    private AnotacaoRepository anotacaoRepo;

    @Autowired
    public AnotacaoController(AnotacaoRepository anotacaoRepo) {
        this.anotacaoRepo = anotacaoRepo;
    }

    // CHAMA TELA CRIAR ANOTAÇÃO
    @RequestMapping("/anotacao/criar.html")
    public String criar() {
        return "/anotacao/criar.html";
    }

    // CRIA ANOTAÇÃO
    @RequestMapping(value = "/anotacao/criar.html", method = RequestMethod.POST)
    public String criar(Anotacao anotacao, HttpSession session) {
        // anotacao.setUsuario((Usuario)session.getAttribute("usuarioLogado"));
        anotacaoRepo.save(anotacao);
        return "redirect:/anotacao/listar.html";
    }

    // LISTA ANOTAÇÕES
    @RequestMapping("/anotacao/listar.html")
    public String listar(Model model) {
        List<Anotacao> listaAnotacoes = anotacaoRepo.findAll();
        if (listaAnotacoes != null) {
            model.addAttribute("anotacoes", listaAnotacoes);
        }
        return "anotacao/listar.html";
    }

    //CHAMA A TELA EDITAR ANOTAÇÃO
    @RequestMapping(value = "/anotacao/editar.html/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Anotacao anotacao = anotacaoRepo.findById(id).get();
        model.addAttribute("anotacao", anotacao);
        return "/anotacao/editar.html";
    }

    //EDITA ANOTAÇÃO
    @RequestMapping(value = "/anotacao/editar.html/{id}", method = RequestMethod.POST)
    public String editar(Anotacao anotacao) {
        anotacaoRepo.save(anotacao);
        return "redirect:/anotacao/listar.html";
    }

    //DELETA ANOTAÇÃO
    @RequestMapping(value = "/anotacao/deletar.html/{id}")
    public String deletar(@PathVariable("id") Long id) {
        anotacaoRepo.deleteById(id);
        return "redirect:/anotacao/listar.html";
    }
}