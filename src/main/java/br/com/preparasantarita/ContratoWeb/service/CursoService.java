package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Curso;
import br.com.preparasantarita.ContratoWeb.repository.CursoRepository;
import br.com.preparasantarita.ContratoWeb.request.CursoRead;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoRead save(Curso curso) {
	return new CursoRead(cursoRepository.save(curso));
    }

    public CursoRead findById(Long id) {
	return new CursoRead(cursoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException()));
    }

    public CursoRead update(Long cursoId, Curso curso) {
	Curso cursoSalvo = find(cursoId);
	curso.setId(cursoSalvo.getId());

	return new CursoRead(cursoRepository.save(curso));
    }

    public void delete(Long cursoId) {
	cursoRepository.delete(find(cursoId));
    }

    public List<CursoRead> findAll() {
	List<Curso> cursos = cursoRepository.findAll();
	return cursos.stream().map(CursoRead::new).collect(Collectors.toList());
    }

    private Curso find(Long id) {
	return cursoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

}
