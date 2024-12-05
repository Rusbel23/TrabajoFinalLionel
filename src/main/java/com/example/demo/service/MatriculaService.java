package com.example.demo.service;

import com.example.demo.model.Matricula;

import java.util.List;

public interface MatriculaService {
    List<Matricula> getAllMatriculas();
    void addMatricula(Matricula matricula);
    Matricula getMatriculaById(Long id);
    void deleteMatricula(Long id);
    void updateMatricula(Matricula matricula);
}
