package br.com.preparasantarita.ContratoWeb.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

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
public class Aluno extends AbstractEntity {

    @NotEmpty
    private String nome;

    @ManyToOne(cascade = CascadeType.DETACH)
    private Profissao profissao;

    @ManyToOne
    private Escolaridade escolaridade;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private LocalDate dataDeNascimento;
    private EstadoCivil estadoCivil;
    private Sexo sexo;
    private String email;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private String rg;
    private String orgaoRg;
    private String cpf;

}
