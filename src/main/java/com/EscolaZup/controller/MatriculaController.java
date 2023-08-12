package com.EscolaZup.controller;

import com.EscolaZup.dto.MatriculaDTO;
import com.EscolaZup.mapper.MatriculaMapper;
import com.EscolaZup.model.Matricula;
import com.EscolaZup.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/zupescola")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    MatriculaMapper matriculaMapper;

    //Endpoint de cadastro das matrículas (post)
    @PostMapping(path = "/cadastramatricula")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaDTO> cadastraMatricula(@RequestBody Matricula matricula) {
        Matricula novaMatricula = matriculaService.cadastraMatricula(matricula);
        return new ResponseEntity<>(matriculaMapper.toDto(matricula),HttpStatus.CREATED);
    }

}
