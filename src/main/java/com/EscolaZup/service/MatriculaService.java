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

        return matriculaRepository.save(matricula);}
}
