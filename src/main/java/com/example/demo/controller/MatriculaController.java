package com.example.demo.controller;

import com.example.demo.model.Matricula;
import com.example.demo.service.impl.MatriculaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

    private final MatriculaServiceImpl matriculaService;

    public MatriculaController(MatriculaServiceImpl matriculaService) {
        this.matriculaService = matriculaService;
    }

    @GetMapping("/listar")
    public String listAllMatriculas(Model model) {
        model.addAttribute("title", "Lista de Matrículas");
        model.addAttribute("listaMatriculas", matriculaService.getAllMatriculas());
        return "pages/list-matricula";
    }

    @GetMapping("/nuevo")
    public String addMatricula(Model model) {
        Matricula matricula = new Matricula();
        model.addAttribute("title", "Nueva Matrícula");
        model.addAttribute("matricula", matricula);
        return "pages/form-matricula";
    }

    @PostMapping("/save")
    public String saveMatricula(@ModelAttribute("matricula") Matricula matricula) {
        matriculaService.addMatricula(matricula);
        return "redirect:/matricula/listar";
    }

    @GetMapping("/showUpdateMatricula/{id}")
    public String updateMatricula(@PathVariable(value = "id") int id, Model model) {
        Matricula matricula = matriculaService.getMatriculaById(id);
        model.addAttribute("matricula", matricula);
        return "pages/form-matriculaActualizar";
    }

    @PostMapping("/update")
    public String updateMatricula(@ModelAttribute("matricula") Matricula matricula) {
        matriculaService.updateMatricula(matricula);
        return "redirect:/matricula/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatricula(@PathVariable(value = "id") int id) {
        matriculaService.deleteMatricula(id);
        return "redirect:/matricula/listar";
    }
}
