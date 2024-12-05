package com.example.demo.service.impl;

import com.example.demo.model.Estudiante;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public List<Estudiante> getAllEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public void addEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante getEstudianteById(int id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.orElseThrow(() -> new RuntimeException("Estudiante no encontrado con ID " + id));
    }

    @Override
    public void updateEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteEstudiante(int id) {
        estudianteRepository.deleteById(id);
    }
}
