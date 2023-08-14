package com.EscolaZup.service;

import com.EscolaZup.model.Aluno;
import com.EscolaZup.model.Curso;
import com.EscolaZup.model.Matricula;
import com.EscolaZup.repository.AlunoRepository;
import com.EscolaZup.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    //Método que cadastra aluno
    public Aluno cadastraAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

}
