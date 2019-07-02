package br.ufjf.dcc193.trabalho03.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufjf.dcc193.trabalho03.models.Usuario;
import br.ufjf.dcc193.trabalho03.repositorys.UsuarioRepository;

/**
 * UsuarioController
 */
@Controller
public class UsuarioController {

    private UsuarioRepository usuarioRepo;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    //CHAMA TELA LOGIN
    @RequestMapping("/index.html")
    public String login(){
        return "/index.html";
    }

    //FAZ LOGIN
    @RequestMapping(value = "/index.html", method = RequestMethod.POST)
    public String login (Usuario usuario, HttpSession session) {
        List<Usuario> listaUsuarios = usuarioRepo.findByEmail(usuario.getEmail());
        if(!listaUsuarios.isEmpty()) {
            Usuario usuarioAux = listaUsuarios.get(0);
            if(this.usuarioRepo.existsById(usuarioAux.getId())) {
                session.setAttribute("usuarioLogado", usuario);
                return "redirect:/menu.html";
            } else {
                return "/index.html";
            }
        }
        return "/index.html";
    }

    //CHAMA TELA MENU
    @RequestMapping("/menu.html")
    public String menu(){
        return "/menu.html";
    }

    //CHAMA TELA CRIAR USUARIO
    @RequestMapping("/usuario/criar.html")
    public String criar() {
        return "/usuario/criar.html";
    }

    //CRIA USUARIO
    @RequestMapping(value = "/usuario/criar.html", method = RequestMethod.POST)
    public String criar(Usuario usuario) {
        usuarioRepo.save(usuario);
        return "redirect:/index.html";
    }

    //LISTA USUARIOS
    @RequestMapping("/usuario/listar.html")
    public String listar(Model model) {
        List<Usuario> listaUsuarios = usuarioRepo.findAll();
        if (listaUsuarios != null) {
            model.addAttribute("usuarios", listaUsuarios);
        }
        return "usuario/listar.html";
    }

    //CHAMA A TELA EDITAR USUARIO
    @RequestMapping(value = "/usuario/editar.html/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioRepo.findById(id).get();
        model.addAttribute("usuario", usuario);
        return "/usuario/editar.html";
    }

    //EDITA USUARIO
    @RequestMapping(value = "/usuario/editar.html/{id}", method = RequestMethod.POST)
    public String editar(Usuario usuario) {
        usuarioRepo.save(usuario);
        return "redirect:/usuario/listar.html";
    }

    //DELETA USUARIO
    @RequestMapping(value = "/usuario/deletar.html/{id}")
    public String deletar(@PathVariable("id") Long id) {
        usuarioRepo.deleteById(id);
        return "redirect:/usuario/listar.html";
    }
}