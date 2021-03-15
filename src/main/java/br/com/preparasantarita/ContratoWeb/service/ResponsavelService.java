package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Responsavel;
import br.com.preparasantarita.ContratoWeb.repository.ResponsavelRepository;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;

    public Responsavel save(Responsavel responsavel) {
	return responsavelRepository.save(responsavel);
    }

    public Responsavel findById(Long id) {
	return responsavelRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Responsavel findByCpf(String cpf) {
	return responsavelRepository.findByCpf(cpf).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Responsavel update(Long responsavelId, Responsavel responsavel) {
	Responsavel responsavelSalvo = findById(responsavelId);
	responsavel.setId(responsavelSalvo.getId());

	return responsavelRepository.save(responsavel);
    }

    public void delete(Long responsavelId) {
	responsavelRepository.delete(findById(responsavelId));
    }

    public List<Responsavel> findAll() {
	return responsavelRepository.findAll();
    }

}
