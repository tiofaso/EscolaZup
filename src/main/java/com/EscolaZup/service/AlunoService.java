package com.EscolaZup.service;

import com.EscolaZup.mapper.AlunoMapper;
import com.EscolaZup.model.Aluno;
import com.EscolaZup.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    @Autowired
    AlunoRepository alunoRepository;

    //Método que cadastra aluno
    public Aluno cadastraAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
