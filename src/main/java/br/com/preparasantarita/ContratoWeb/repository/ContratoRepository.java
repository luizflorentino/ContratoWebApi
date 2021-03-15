package br.com.preparasantarita.ContratoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.preparasantarita.ContratoWeb.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
