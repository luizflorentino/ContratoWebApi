package br.com.preparasantarita.ContratoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.preparasantarita.ContratoWeb.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByCpf(String cpf);
}
