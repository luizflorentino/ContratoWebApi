package br.com.preparasantarita.ContratoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.preparasantarita.ContratoWeb.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {

}
