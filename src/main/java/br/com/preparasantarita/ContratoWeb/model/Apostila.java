package br.com.preparasantarita.ContratoWeb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Apostila {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Modulo modulo;

	private String nome;
	private String valorVendaApostila;
	private String valorCompraApostila;
	private Integer duracaoEmMes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValorVendaApostila() {
		return valorVendaApostila;
	}

	public void setValorVendaApostila(String valorVendaApostila) {
		this.valorVendaApostila = valorVendaApostila;
	}

	public String getValorCompraApostila() {
		return valorCompraApostila;
	}

	public void setValorCompraApostila(String valorCompraApostila) {
		this.valorCompraApostila = valorCompraApostila;
	}

	public Integer getDuracaoEmMes() {
		return duracaoEmMes;
	}

	public void setDuracaoEmMes(Integer duracaoEmMes) {
		this.duracaoEmMes = duracaoEmMes;
	}
}
