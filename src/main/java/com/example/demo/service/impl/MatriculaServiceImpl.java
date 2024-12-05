package com.example.demo.service.impl;

import com.example.demo.model.Matricula;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.service.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public List<Matricula> getAllMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public void addMatricula(Matricula matricula) {
        matriculaRepository.save(matricula);
    }

    @Override
    public Matricula getMatriculaById(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);
        return matricula.orElseThrow(() -> new RuntimeException("Matricula no encontrada con ID " + id));
    }

    @Override
    public void updateMatricula(Matricula matricula) {
        matriculaRepository.save(matricula);
    }

    @Override
    public void deleteMatricula(Long id) {
        matriculaRepository.deleteById(id);
    }
}
