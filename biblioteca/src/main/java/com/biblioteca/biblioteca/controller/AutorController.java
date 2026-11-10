package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import com.biblioteca.biblioteca.repository.AutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final AutorRepository repository;

    public AutorController(AutorRepository repository) {
        this.repository = repository;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", repository.findAll());
        return "autores/lista";
    }

    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    // CADASTRAR
    @PostMapping
    public String cadastrarAutor(@ModelAttribute Autor autor) {
        repository.save(autor);
        return "redirect:/autores";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/autores";
    }
}