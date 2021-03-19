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

import br.com.preparasantarita.ContratoWeb.entity.Modulo;
import br.com.preparasantarita.ContratoWeb.request.ModuloDTO;
import br.com.preparasantarita.ContratoWeb.service.ModuloService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/modulos")
public class ModuloController {

    private final ModuloService moduloService;

    @PostMapping
    public ResponseEntity<ModuloDTO> create(@Valid @RequestBody Modulo modulo, BindingResult result) {

	if (result.hasErrors()) {

	}

	return ResponseEntity.status(HttpStatus.CREATED).body(moduloService.save(modulo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModuloDTO> get(@PathVariable Long id) {
	return ResponseEntity.ok(moduloService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModuloDTO> update(@PathVariable(value = "id") Long id, @Valid @RequestBody Modulo modulo,
	    BindingResult result) throws MethodArgumentNotValidException {

	if (result.hasErrors()) {
	    throw new MethodArgumentNotValidException(null, result);
	}

	return ResponseEntity.ok(moduloService.update(id, modulo));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
	moduloService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<ModuloDTO>> findAll() {
	return ResponseEntity.ok(moduloService.findAll());
    }

}
