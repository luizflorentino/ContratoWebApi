package br.com.preparasantarita.ContratoWeb.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
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
public class PrestadorDeServico extends AbstractEntity {

    private String razaoSocial;
    private String nomeFantasia;
    private LocalDate dataAbertura;
    private String email;
    private String telefones;
    private String cnpj;
    private String inscr;

    @OneToOne
    private Endereco endereco;

}
