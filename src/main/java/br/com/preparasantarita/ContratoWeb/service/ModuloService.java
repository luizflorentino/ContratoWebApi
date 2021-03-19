package br.com.preparasantarita.ContratoWeb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.entity.Modulo;
import br.com.preparasantarita.ContratoWeb.repository.ModuloRepository;
import br.com.preparasantarita.ContratoWeb.request.ModuloDTO;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModuloService {

    private final ModuloRepository moduloRepository;

    public ModuloDTO save(Modulo modulo) {
	return new ModuloDTO(moduloRepository.save(modulo));
    }

    public ModuloDTO findById(Long id) {
	return new ModuloDTO(moduloRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException()));
    }

    public ModuloDTO update(Long moduloId, Modulo modulo) {
	Modulo moduloSalvo = find(moduloId);
	modulo.setId(moduloSalvo.getId());

	return new ModuloDTO(moduloRepository.save(modulo));
    }

    public void delete(Long moduloId) {
	moduloRepository.delete(find(moduloId));
    }

    public List<ModuloDTO> findAll() {
	List<Modulo> modulos = moduloRepository.findAll();
	return modulos.stream().map(ModuloDTO::new).collect(Collectors.toList());
    }

    private Modulo find(Long id) {
	return moduloRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

}
