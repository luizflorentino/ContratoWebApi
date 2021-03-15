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

import br.com.preparasantarita.ContratoWeb.entity.Curso;
import br.com.preparasantarita.ContratoWeb.service.CursoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/cursos")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> create(@Valid @RequestBody Curso curso, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> get(@PathVariable Long id) {
	return ResponseEntity.ok(cursoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Curso curso,
	    BindingResult result) throws MethodArgumentNotValidException {

	if (result.hasErrors()) {
	    throw new MethodArgumentNotValidException(null, result);
	}

	return ResponseEntity.ok(cursoService.update(id, curso));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
	cursoService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
	return ResponseEntity.ok(cursoService.findAll());
    }

}
