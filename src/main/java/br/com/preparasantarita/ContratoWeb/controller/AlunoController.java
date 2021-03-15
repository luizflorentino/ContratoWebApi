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

import br.com.preparasantarita.ContratoWeb.entity.Aluno;
import br.com.preparasantarita.ContratoWeb.service.AlunoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> create(@Valid @RequestBody Aluno aluno, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(aluno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> get(@PathVariable Long id) {
	return ResponseEntity.ok(alunoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Aluno aluno,
	    BindingResult result) throws MethodArgumentNotValidException {

	if (result.hasErrors()) {
	    throw new MethodArgumentNotValidException(null, result);
	}

	return ResponseEntity.ok(alunoService.update(id, aluno));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
	alunoService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
	return ResponseEntity.ok(alunoService.findAll());
    }

}
