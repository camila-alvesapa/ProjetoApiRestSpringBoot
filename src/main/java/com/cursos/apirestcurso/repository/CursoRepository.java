package com.cursos.apirestcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursos.apirestcurso.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
	//método que vai procurar um único produto através do id
	Curso findById(long id);
	
}