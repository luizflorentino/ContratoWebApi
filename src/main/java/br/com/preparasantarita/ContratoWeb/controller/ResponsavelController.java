package br.com.preparasantarita.ContratoWeb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.preparasantarita.ContratoWeb.entity.Responsavel;
import br.com.preparasantarita.ContratoWeb.service.ResponsavelService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/responsaveis")
public class ResponsavelController {

    private final ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsavel> create(@Valid @RequestBody Responsavel responsavel, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.save(responsavel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> get(@PathVariable Long id) {
	return ResponseEntity.ok(responsavelService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsavel> update(@PathVariable(value = "id") Long id,
	    @Valid @RequestBody Responsavel responsavel, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.ok(responsavelService.update(id, responsavel));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
	responsavelService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> findAll() {
	return ResponseEntity.ok(responsavelService.findAll());
    }

}
