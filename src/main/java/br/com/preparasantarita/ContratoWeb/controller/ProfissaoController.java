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

import br.com.preparasantarita.ContratoWeb.entity.Profissao;
import br.com.preparasantarita.ContratoWeb.service.ProfissaoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/profissoes")
public class ProfissaoController {

    private final ProfissaoService profissaoService;

    @PostMapping
    public ResponseEntity<Profissao> create(@Valid @RequestBody Profissao profissao, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.status(HttpStatus.CREATED).body(profissaoService.save(profissao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profissao> get(@PathVariable Long id) {
	return ResponseEntity.ok(profissaoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profissao> update(@PathVariable(value = "id") Long id,
	    @Valid @RequestBody Profissao profissao, BindingResult result) throws MethodArgumentNotValidException {

	if (result.hasErrors()) {
	    throw new MethodArgumentNotValidException(null, result);
	}

	return ResponseEntity.ok(profissaoService.update(id, profissao));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
	profissaoService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Profissao>> findAll() {
	return ResponseEntity.ok(profissaoService.findAll());
    }

}
