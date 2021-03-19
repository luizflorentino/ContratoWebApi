package br.com.preparasantarita.ContratoWeb.request;

import java.util.List;
import java.util.stream.Collectors;

import br.com.preparasantarita.ContratoWeb.entity.Curso;
import lombok.Data;

@Data
public class CursoRead {

    private Long id;
    private String nome;
    private List<ModuloDTO> modulos;

    public CursoRead(Curso curso) {
	this.id = curso.getId();
	this.nome = curso.getNome();
	this.modulos = curso.getModulos().stream().map(ModuloDTO::new).collect(Collectors.toList());
    }

}
