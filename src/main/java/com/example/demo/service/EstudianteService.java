package com.example.demo.service;

import com.example.demo.model.Estudiante;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> getAllEstudiantes();
    void addEstudiante(Estudiante estudiante);
    Estudiante getEstudianteById(int id);
    void deleteEstudiante(int id);
    void updateEstudiante(Estudiante estudiante);
}
