package com.EscolaZup.repository;

import com.EscolaZup.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
//    @Modifying
//    @Query("UPDATE Matricula m SET m.cursoid = :cursoid , m.datamatricula = :data WHERE m.alunoid = :alunoid")
//   public void setCursoId(@Param("alunoid") Long alunoid, @Param("cursoid") Long cursoid, @Param("datamatricula") LocalDate data );

   public Matricula findByAlunoId(Long alunoid);
}
