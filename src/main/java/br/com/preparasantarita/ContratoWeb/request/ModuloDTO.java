package br.com.preparasantarita.ContratoWeb.request;

import java.util.List;
import java.util.stream.Collectors;

import br.com.preparasantarita.ContratoWeb.entity.Modulo;
import lombok.Data;

@Data
public class ModuloDTO {

    private Long id;
    private String nome;
    private int cargaHoraria;
    private String familia;
    private String modalidade;
    private List<ApostilaGetList> apostilas;

    public ModuloDTO(Modulo modulo) {
	this.id = modulo.getId();
	this.nome = modulo.getNome();
	this.cargaHoraria = modulo.getCargaHoraria();
	this.familia = modulo.getFamilia().getDisplayValue();
	this.modalidade = modulo.getModalidade().getDisplayValue();
	this.apostilas = modulo.getApostilas().stream().map(ApostilaGetList::new).collect(Collectors.toList());
    }

}
