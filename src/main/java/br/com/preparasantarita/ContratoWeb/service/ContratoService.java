package br.com.preparasantarita.ContratoWeb.service;

import org.springframework.stereotype.Service;

import br.com.preparasantarita.ContratoWeb.repository.ContratoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContratoService {

    private final ContratoRepository contratoRepository;

}
