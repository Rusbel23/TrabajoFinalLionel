package com.example.demo.service.impl;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public void addCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Curso getCursoById(int id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElseThrow(() -> new RuntimeException("Curso no encontrado con ID " + id));
    }

    @Override
    public void updateCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(int id) {
        cursoRepository.deleteById(id);
    }
}
