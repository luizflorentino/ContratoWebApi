package br.com.preparasantarita.ContratoWeb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.preparasantarita.ContratoWeb.entity.DiaDaSemana;
import br.com.preparasantarita.ContratoWeb.entity.EstadoCivil;
import br.com.preparasantarita.ContratoWeb.entity.Familia;
import br.com.preparasantarita.ContratoWeb.entity.Horario;
import br.com.preparasantarita.ContratoWeb.entity.Modalidade;
import br.com.preparasantarita.ContratoWeb.entity.Sexo;
import br.com.preparasantarita.ContratoWeb.entity.TipoParcela;
import br.com.preparasantarita.ContratoWeb.service.AuxiliaFormService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/auxiliaForms")
public class AuxiliaFormController {

    private final AuxiliaFormService auxiliaFormService;

    @GetMapping("/sexos")
    public ResponseEntity<Sexo[]> getSexos() {
	return ResponseEntity.ok(auxiliaFormService.getSexos());
    }

    @GetMapping("/estadosCivis")
    public ResponseEntity<EstadoCivil[]> getEstadosCivis() {
	return ResponseEntity.ok(auxiliaFormService.getEstadosCivis());
    }

    @GetMapping("/tiposParcelas")
    public ResponseEntity<TipoParcela[]> getTiposParcelas() {
	return ResponseEntity.ok(auxiliaFormService.getTiposParcelas());
    }

    @GetMapping("/modalidades")
    public ResponseEntity<Modalidade[]> getModalidades() {
	return ResponseEntity.ok(auxiliaFormService.getModalidades());
    }

    @GetMapping("/horarios")
    public ResponseEntity<Horario[]> getHorarios() {
	return ResponseEntity.ok(auxiliaFormService.getHorarios());
    }

    @GetMapping("/familias")
    public ResponseEntity<Familia[]> getFamilias() {
	return ResponseEntity.ok(auxiliaFormService.getFamilias());
    }

    @GetMapping("/diasDaSemana")
    public ResponseEntity<DiaDaSemana[]> getDiasDaSemana() {
	return ResponseEntity.ok(auxiliaFormService.getDiasDaSemana());
    }
}
