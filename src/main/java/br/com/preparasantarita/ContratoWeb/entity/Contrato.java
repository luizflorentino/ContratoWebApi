package br.com.preparasantarita.ContratoWeb.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contrato extends AbstractEntity {

    private String numero;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Aluno aluno;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Responsavel contratante;

    @OneToOne
    private Curso curso;

    @ManyToOne
    private PrestadorDeServico prestadorDeServico;

    private LocalDate dataInicio;
    private LocalDate dataFinal;

    @OneToMany
    @Singular
    private List<Agendamento> agendamentos;

    @OneToMany
    @Singular
    private List<Parcela> parcelas;

}
