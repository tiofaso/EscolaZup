package com.EscolaZup.service;

import com.EscolaZup.model.Curso;
import com.EscolaZup.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    //Método que cadastra um novo curso
    public Curso cadastraCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

}
