package br.com.preparasantarita.ContratoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.preparasantarita.ContratoWeb.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
