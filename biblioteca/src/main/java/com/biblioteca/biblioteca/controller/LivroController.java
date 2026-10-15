package com.biblioteca.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @GetMapping
    public String inicio(Model model) {
        model.addAttribute(
                "livro",
                "Livros"
        );
        return "livros/inicio";
    }
}