package br.com.preparasantarita.ContratoWeb.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

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
public class Parcela extends AbstractEntity {

    private LocalDate vencimento;
    private TipoParcela tipo;
    private int ordem;
    private BigDecimal valor;
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Contrato contrato;

}
