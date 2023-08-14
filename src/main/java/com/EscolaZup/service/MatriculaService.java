package com.EscolaZup.service;

import com.EscolaZup.model.Matricula;
import com.EscolaZup.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    //Método que cadastra matrícula
    public Matricula cadastraMatricula(Matricula matricula) {
        LocalDate dataMatricula = LocalDate.now();
        matricula.setDatamatricula(dataMatricula);

        return matriculaRepository.save(matricula);
    }

    //Método que atualiza curso do ano
    public Matricula atualizaCurso(Matricula matricula) {

        Long alunoId = matricula.getAlunoid();
        Long cursoId = matricula.getCursoid();
        LocalDate dataMatricula = LocalDate.now();

        Matricula novoCurso = buscaAlunoId(alunoId);


       if(matricula.getAlunoid() != null) {
            novoCurso.setCursoid(cursoId);
            novoCurso.setDatamatricula(dataMatricula);
      }
        return matriculaRepository.save(matricula);
    }

    //Método que pesquisa por aluno na base
    public Matricula buscaAlunoId(Long id) {
        return matriculaRepository.findByAlunoId(id);
    }
}
