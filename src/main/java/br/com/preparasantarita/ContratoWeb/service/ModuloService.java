package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Modulo;
import br.com.preparasantarita.ContratoWeb.repository.ModuloRepository;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModuloService {

    private final ModuloRepository moduloRepository;

    public Modulo save(Modulo modulo) {
	return moduloRepository.save(modulo);
    }

    public Modulo findById(Long id) {
	return moduloRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    public Modulo update(Long moduloId, Modulo modulo) {
	Modulo moduloSalvo = findById(moduloId);
	modulo.setId(moduloSalvo.getId());

	return moduloRepository.save(modulo);
    }

    public void delete(Long moduloId) {
	moduloRepository.delete(findById(moduloId));
    }

    public List<Modulo> findAll() {
	return moduloRepository.findAll();
    }

}
