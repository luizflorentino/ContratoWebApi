package br.com.preparasantarita.ContratoWeb.entity;

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
public class Endereco extends AbstractEntity {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;
    private String complemento;

}
