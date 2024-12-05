package com.example.demo.controller;

import com.example.demo.model.Curso;
import com.example.demo.service.impl.CursoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoServiceImpl cursoService;

    public CursoController(CursoServiceImpl cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("/listar")
    public String listAllCursos(Model model) {
        model.addAttribute("title", "Lista de Cursos");
        model.addAttribute("listaCursos", cursoService.getAllCursos());
        return "pages/list-curso";
    }

    @GetMapping("/nuevo")
    public String addCurso(Model model) {
        Curso curso = new Curso();
        model.addAttribute("title", "Agregar Curso");
        model.addAttribute("curso", curso);
        return "pages/form-curso";
    }

    @PostMapping("/save")
    public String saveCurso(@ModelAttribute("curso") Curso curso) {
        cursoService.addCurso(curso);
        return "redirect:/curso/listar";
    }

    @GetMapping("/showUpdateCurso/{id}")
    public String updateCurso(@PathVariable(value = "id") int id, Model model) {
        Curso curso = cursoService.getCursoById(id);
        model.addAttribute("curso", curso);
        return "pages/form-cursoActualizar";
    }

    @PostMapping("/update")
    public String updateCurso(@ModelAttribute("curso") Curso curso) {
        cursoService.updateCurso(curso);
        return "redirect:/curso/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteCurso(@PathVariable(value = "id") int id) {
        cursoService.deleteCurso(id);
        return "redirect:/curso/listar";
    }
}
