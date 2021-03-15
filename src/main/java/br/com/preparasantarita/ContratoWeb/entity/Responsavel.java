package br.com.preparasantarita.ContratoWeb.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Responsavel extends AbstractEntity {

    private String nome;

    @ManyToOne
    private Profissao profissao;

    @ManyToOne
    private Escolaridade escolaridade;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private EstadoCivil estadoCivil;
    private Sexo sexo;
    private String email;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String rg;
    private String orgaoRg;
    private String cpf;
    private LocalDate dataDeNascimento;

    @Override
    public String getLink() {
	return "/responsaveis/" + getId();
    }
}
