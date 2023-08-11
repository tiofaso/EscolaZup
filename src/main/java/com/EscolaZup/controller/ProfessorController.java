package com.EscolaZup.controller;

import com.EscolaZup.dto.CursoDTO;
import com.EscolaZup.dto.ProfessorDTO;
import com.EscolaZup.mapper.ProfessorMapper;
import com.EscolaZup.model.Professor;
import com.EscolaZup.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/zupescola")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @Autowired
    ProfessorMapper professorMapper;

    //Endpoint de cadastro do professor (post)
    @PostMapping(path = "/cadastraprofessor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorDTO> cadastraProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.cadastrarProfessor(professor);
        return new ResponseEntity<>(professorMapper.toDto(professor), HttpStatus.CREATED);
    }
}
