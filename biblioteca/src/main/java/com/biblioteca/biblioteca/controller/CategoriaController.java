package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", repository.findAll());
        return "categorias/lista";
    }

    @GetMapping("/novo")
    public String nova(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    // CADASTRAR
    @PostMapping
    public String cadastrar(@ModelAttribute Categoria categoria) {
        repository.save(categoria);
        return "redirect:/categorias";
    }

    // EXCLUIR
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/categorias";
    }
}