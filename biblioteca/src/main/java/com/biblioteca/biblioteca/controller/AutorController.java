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

    // READ: apresenta a lista de autores cadastrados.
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("autores", repository.findAll());
        return "autores/lista";
    }

    // CREATE: abre o formulário vazio.
    @GetMapping("/novo")
    public String novoAutor(Model model) {
        model.addAttribute("autor", new Autor());
        model.addAttribute("tituloPagina", "Cadastrar autor");
        return "autores/form";
    }

    // UPDATE: busca o autor pelo ID e abre o mesmo formulário preenchido.
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Autor autor = repository.findById(id).orElse(null);

        if (autor == null) {
            return "redirect:/autores";
        }

        model.addAttribute("autor", autor);
        model.addAttribute("tituloPagina", "Editar autor");
        return "autores/form";
    }

    // CREATE/UPDATE: save() insere quando não há ID e atualiza quando há ID.
    @PostMapping
    public String salvar(@ModelAttribute Autor autor, Model model) {
        if (autor.getNome() == null || autor.getNome().isBlank()) {
            model.addAttribute("erro", "Informe o nome do autor.");
            model.addAttribute("tituloPagina",
                    autor.getId() == null ? "Cadastrar autor" : "Editar autor");
            return "autores/form";
        }

        if (autor.getNacionalidade() == null || autor.getNacionalidade().isBlank()) {
            model.addAttribute("erro", "Informe a nacionalidade do autor.");
            model.addAttribute("tituloPagina",
                    autor.getId() == null ? "Cadastrar autor" : "Editar autor");
            return "autores/form";
        }

        autor.setNome(autor.getNome().trim());
        autor.setNacionalidade(autor.getNacionalidade().trim());
        repository.save(autor);

        return "redirect:/autores";
    }

    // DELETE: exclui o registro pelo ID persistente.
    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        return "redirect:/autores";
    }
}
