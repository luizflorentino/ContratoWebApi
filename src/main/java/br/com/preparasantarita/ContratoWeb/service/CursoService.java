package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Curso;
import br.com.preparasantarita.ContratoWeb.repository.CursoRepository;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoRepository cursoRepository;

    public Curso save(Curso curso) {
	return cursoRepository.save(curso);
    }

    public Curso findById(Long id) {
	return cursoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Curso update(Long cursoId, Curso curso) {
	Curso cursoSalvo = findById(cursoId);
	curso.setId(cursoSalvo.getId());

	return cursoRepository.save(curso);
    }

    public void delete(Long cursoId) {
	cursoRepository.delete(findById(cursoId));
    }

    public List<Curso> findAll() {
	return cursoRepository.findAll();
    }

}
