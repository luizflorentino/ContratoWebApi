package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Escolaridade;
import br.com.preparasantarita.ContratoWeb.repository.EscolaridadeRepository;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EscolaridadeService {

    private final EscolaridadeRepository escolaridadeRepository;

    public Escolaridade save(Escolaridade escolaridade) {
	return escolaridadeRepository.save(escolaridade);
    }

    public Escolaridade findById(Long id) {
	return escolaridadeRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Escolaridade update(Long escolaridadeId, Escolaridade escolaridade) {
	Escolaridade escolaridadeSalvo = findById(escolaridadeId);
	escolaridade.setId(escolaridadeSalvo.getId());

	return escolaridadeRepository.save(escolaridade);
    }

    public void delete(Long escolaridadeId) {
	escolaridadeRepository.delete(findById(escolaridadeId));
    }

    public List<Escolaridade> findAll() {
	return escolaridadeRepository.findAll();
    }

}
