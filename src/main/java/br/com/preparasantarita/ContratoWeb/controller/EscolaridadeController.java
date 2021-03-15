package br.com.preparasantarita.ContratoWeb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.preparasantarita.ContratoWeb.entity.Escolaridade;
import br.com.preparasantarita.ContratoWeb.service.EscolaridadeService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/escolaridades")
public class EscolaridadeController {

    private final EscolaridadeService escolaridadeService;

    @PostMapping
    public ResponseEntity<Escolaridade> create(@Valid @RequestBody Escolaridade escolaridade, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.status(HttpStatus.CREATED).body(escolaridadeService.save(escolaridade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escolaridade> get(@PathVariable Long id) {
	return ResponseEntity.ok(escolaridadeService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escolaridade> update(@PathVariable(value = "id") Long id,
	    @Valid @RequestBody Escolaridade escolaridade, BindingResult result)
	    throws MethodArgumentNotValidException {

	if (result.hasErrors()) {
	    throw new MethodArgumentNotValidException(null, result);
	}

	return ResponseEntity.ok(escolaridadeService.update(id, escolaridade));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
	escolaridadeService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Escolaridade>> findAll() {
	return ResponseEntity.ok(escolaridadeService.findAll());
    }

}
