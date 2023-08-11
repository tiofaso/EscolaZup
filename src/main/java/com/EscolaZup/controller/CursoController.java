package com.EscolaZup.controller;

import com.EscolaZup.dto.CursoDTO;
import com.EscolaZup.mapper.CursoMapper;
import com.EscolaZup.model.Curso;
import com.EscolaZup.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/zupescola")
public class CursoController {
    @Autowired
    CursoService cursoService;

    @Autowired
    CursoMapper cursoMapper;

    //Endpoint de cadastro de cursos (post)
    @PostMapping(path = "/cadastracurso")
    public ResponseEntity<CursoDTO> cadastraCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.cadastraCurso(curso);
        return new ResponseEntity<>(cursoMapper.toDto(novoCurso), HttpStatus.CREATED);
    }
}
