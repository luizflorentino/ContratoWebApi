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
public class Profissao extends AbstractEntity {

    private String descricao;

    @Override
    public String getLink() {
	return "/profissoes/" + getId();
    }

}
