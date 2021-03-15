package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Aluno;
import br.com.preparasantarita.ContratoWeb.repository.AlunoRepository;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public Aluno save(Aluno aluno) {
	return alunoRepository.save(aluno);
    }

    public Aluno findById(Long id) {
	return alunoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Aluno update(Long alunoId, Aluno aluno) {
	Aluno alunoSalvo = findById(alunoId);
	aluno.setId(alunoSalvo.getId());

	return alunoRepository.save(aluno);
    }

    public void delete(Long alunoId) {
	alunoRepository.delete(findById(alunoId));
    }

    public List<Aluno> findAll() {
	return alunoRepository.findAll();
    }

}
