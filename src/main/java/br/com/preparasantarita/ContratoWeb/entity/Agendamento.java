package br.com.preparasantarita.ContratoWeb.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

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
public class Agendamento extends AbstractEntity {

    private DiaDaSemana dia;

    @ElementCollection(targetClass = Horario.class)
    private List<Horario> horarios;

}
