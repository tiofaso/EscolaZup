package com.EscolaZup;

import com.EscolaZup.controller.MatriculaController;
import com.EscolaZup.mapper.MatriculaMapper;
import com.EscolaZup.model.Aluno;
import com.EscolaZup.model.Curso;
import com.EscolaZup.model.Matricula;
import com.EscolaZup.service.AlunoService;
import com.EscolaZup.service.MatriculaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MatriculaController.class)
public class MatriculaControllerTest {

    @MockBean
    private MatriculaService matriculaService;

    @MockBean
    private MatriculaMapper matriculaMapper;

    @MockBean
    private AlunoService alunoService;

    @Autowired
    private MockMvc mockMvc;

    @Test //Teste do endpoint de cadastro de matrículas
    public void cadastraMatriculaTest() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/zupescola/cadastramatricula")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"alunoid\":\"4\",\"cursoid\":\"4\"}"))
                .andExpect(status().isCreated());
    }

    ///Todo ainda tá dando erro de java.lang.AssertionError: No value at JSON path
    @Test //Teste do endpoint de atualizar o curso do aluno
    public void atualizaCurso() throws Exception {
        Aluno aluno = new Aluno(1l,"Fabio Sousa",40,"fabio.vaz@zup.com.br");
        Curso curso = new Curso(4L,"Lógica de programação",60);
        LocalDate data = LocalDate.now();
        aluno.setId(1L);
        curso.setId(4L);

        Matricula matricula = new Matricula(0L,data,aluno,aluno.getId(),curso, curso.getId());

         this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/zupescola/atualizacurso/{alunoid}/{cursoid}",1L,4L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(asJsonString(matricula)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.alunoid").value(1L))
                .andExpect(jsonPath("$.curso").value(4L));

    }

    private String asJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writeValueAsString(obj);
    }

}
