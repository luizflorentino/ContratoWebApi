package br.com.preparasantarita.ContratoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.preparasantarita.ContratoWeb.entity.Responsavel;

public interface ResponsavelRepository extends JpaRepository<Responsavel, Long> {

    Optional<Responsavel> findByCpf(String cpf);
}
