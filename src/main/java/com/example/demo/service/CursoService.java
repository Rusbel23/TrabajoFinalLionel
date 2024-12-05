package com.example.demo.service;

import com.example.demo.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> getAllCursos();
    void addCurso(Curso curso);
    Curso getCursoById(int id);
    void deleteCurso(int id);
    void updateCurso(Curso curso);
}
