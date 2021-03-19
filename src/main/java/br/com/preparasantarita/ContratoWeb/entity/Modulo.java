package br.com.preparasantarita.ContratoWeb.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

public class Modulo extends AbstractEntity {

    private String nome;

    private int cargaHoraria;

    private Familia familia;

    private Modalidade modalidade;

    @OneToMany(mappedBy = "modulo")
    @Singular
    private List<Apostila> apostilas;

    @ManyToMany(mappedBy = "modulos")
    @Singular
    @JsonBackReference
    private List<Curso> cursos;

}
