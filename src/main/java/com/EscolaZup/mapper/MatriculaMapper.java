package com.EscolaZup.mapper;

import com.EscolaZup.dto.MatriculaDTO;
import com.EscolaZup.model.Matricula;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MatriculaMapper {
    public MatriculaDTO toDto(Matricula matricula) {
       MatriculaDTO dto = new MatriculaDTO();

       dto.setCursoIdDto(matricula.getId());
       dto.setAlunoIdDto(matricula.getAlunoid());

       dto.setDataMatriculaDto(matricula.getDatamatricula());

       return dto;
    }
}
