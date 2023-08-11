package com.EscolaZup.repository;

import com.EscolaZup.model.Curso;
import com.EscolaZup.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
