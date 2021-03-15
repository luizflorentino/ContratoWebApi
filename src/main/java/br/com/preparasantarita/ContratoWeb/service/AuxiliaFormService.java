package br.com.preparasantarita.ContratoWeb.service;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.DiaDaSemana;
import br.com.preparasantarita.ContratoWeb.entity.EstadoCivil;
import br.com.preparasantarita.ContratoWeb.entity.Familia;
import br.com.preparasantarita.ContratoWeb.entity.Horario;
import br.com.preparasantarita.ContratoWeb.entity.Modalidade;
import br.com.preparasantarita.ContratoWeb.entity.Sexo;
import br.com.preparasantarita.ContratoWeb.entity.TipoParcela;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuxiliaFormService {

    public Sexo[] getSexos() {
	return Sexo.values();
    }

    public EstadoCivil[] getEstadosCivis() {
	return EstadoCivil.values();
    }

    public TipoParcela[] getTiposParcelas() {
	return TipoParcela.values();
    }

    public Modalidade[] getModalidades() {
	return Modalidade.values();
    }

    public Horario[] getHorarios() {
	return Horario.values();
    }

    public Familia[] getFamilias() {
	return Familia.values();
    }

    public DiaDaSemana[] getDiasDaSemana() {
	return DiaDaSemana.values();
    }
}
