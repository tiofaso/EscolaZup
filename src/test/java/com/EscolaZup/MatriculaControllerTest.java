package com.EscolaZup;

import com.EscolaZup.controller.MatriculaController;
import com.EscolaZup.mapper.MatriculaMapper;
import com.EscolaZup.model.Aluno;
import com.EscolaZup.model.Curso;
import com.EscolaZup.service.AlunoService;
import com.EscolaZup.service.MatriculaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MatriculaController.class)
public class MatriculaControllerTest {

    @MockBean
    private MatriculaService matriculaService;

    @MockBean
    private MatriculaMapper matriculaMapper;

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
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/api/zupescola/atualizacurso/{alunoid}/{cursoid}",4,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.alunoid").value(4))
                .andExpect(jsonPath("$.cursoid").value(2))
                ;

    }

}
