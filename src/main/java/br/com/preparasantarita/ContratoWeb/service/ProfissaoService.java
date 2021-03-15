package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Profissao;
import br.com.preparasantarita.ContratoWeb.repository.ProfissaoRepository;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfissaoService {

    private final ProfissaoRepository profissaoRepository;

    public Profissao save(Profissao profissao) {
	return profissaoRepository.save(profissao);
    }

    public Profissao findById(Long id) {
	return profissaoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Profissao update(Long profissaoId, Profissao profissao) {
	Profissao profissaoSalvo = findById(profissaoId);
	profissao.setId(profissaoSalvo.getId());

	return profissaoRepository.save(profissao);
    }

    public void delete(Long profissaoId) {
	profissaoRepository.delete(findById(profissaoId));
    }

    public List<Profissao> findAll() {
	return profissaoRepository.findAll();
    }

}
