package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private List<Autor> autores = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", autores);
        return "autores/lista";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @GetMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}