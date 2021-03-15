package br.com.preparasantarita.ContratoWeb.entity;

import java.math.BigDecimal;

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
public class Apostila extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    private Modulo modulo;

    private String nome;
    private BigDecimal valorVenda;
    private BigDecimal valorCompra;
    private Integer duracaoEmMes;

}
