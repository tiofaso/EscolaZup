package com.EscolaZup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_matricula")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date datamatricula;

    @OneToOne
    @JoinColumn(name = "alunoid", referencedColumnName = "id")
    private Aluno aluno;
    private Long alunoid;

    @OneToOne
    @JoinColumn(name = "cursoid", referencedColumnName = "id")
    private Curso curso;
    private Long cursoid;
}
