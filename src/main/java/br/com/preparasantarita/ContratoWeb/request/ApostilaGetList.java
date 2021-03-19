package br.com.preparasantarita.ContratoWeb.request;

import java.math.BigDecimal;

import br.com.preparasantarita.ContratoWeb.entity.Apostila;
import lombok.Data;

@Data
public class ApostilaGetList {

    private Long id;
    private String nome;
    private BigDecimal valorVenda;
    private BigDecimal valorCompra;
    private Integer duracaoEmMes;

    public ApostilaGetList(Apostila apostila) {
	this.id = apostila.getId();
	this.nome = apostila.getNome();
	this.valorCompra = apostila.getValorCompra();
	this.valorVenda = apostila.getValorVenda();
	this.duracaoEmMes = apostila.getDuracaoEmMes();
    }

}
