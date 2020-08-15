package br.com.preparasantarita.ContratoWeb.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.preparasantarita.ContratoWeb.helpers.FlashMessage;
import br.com.preparasantarita.ContratoWeb.helpers.FlashMessageType;
import br.com.preparasantarita.ContratoWeb.model.Contrato;
import br.com.preparasantarita.ContratoWeb.repository.ContratoRepository;
import br.com.preparasantarita.ContratoWeb.transfer.ContratoForm;
import br.com.preparasantarita.ContratoWeb.transfer.DetalhesDoContratoDTO;
import br.com.preparasantarita.ContratoWeb.validation.RecursoNaoEncontradoException;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

	private static final String CONTRATO_FORM = "contratos/form";
	private static final String CONTRATO_DETALHE = "contratos/detalhe";
	private static final String CONTRATO_LISTAR = "contratos/index";
	private static final String CONTRATO_UPDATE_FORM = "contratos/update_form";

	@Autowired
	private ContratoRepository contratoRepository;

	@GetMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView(CONTRATO_FORM);
		modelAndView.addObject("contratoForm", new ContratoForm());
		return modelAndView;
	}

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView(CONTRATO_LISTAR);

		List<Contrato> contratos = contratoRepository.findAll();
		modelAndView.addObject("contratos", contratos);

		return modelAndView;
	}

	@PostMapping
	public ModelAndView cadastrar(@ModelAttribute("contratoForm") @Valid ContratoForm contratoform,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView(CONTRATO_FORM);
		modelAndView.addObject("contratoForm", contratoform);

		if (!bindingResult.hasErrors()) {
			Contrato contrato = contratoform.toModel();
			contratoRepository.save(contrato);
			redirectAttributes.addFlashAttribute("message",
					new FlashMessage(FlashMessageType.success, "Contrato cadastrado com suscesso."));
			modelAndView = new ModelAndView("redirect:/contratos/" + contrato.getId());
		}
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView(CONTRATO_DETALHE);
		Optional<Contrato> contrato = contratoRepository.findById(id);

		DetalhesDoContratoDTO contratoDto = new DetalhesDoContratoDTO(
				contrato.orElseThrow(() -> new RecursoNaoEncontradoException()));
		modelAndView.addObject("contrato", contratoDto);

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView(CONTRATO_UPDATE_FORM);
		Optional<Contrato> contrato = contratoRepository.findById(id);

		ContratoForm contratoForm = new ContratoForm(contrato.orElseThrow(() -> new RecursoNaoEncontradoException()));
		modelAndView.addObject("contratoForm", contratoForm);

		return modelAndView;
	}

	@PostMapping(value = "/{id}")
	public ModelAndView atualizar(@ModelAttribute("contratoForm") @Valid ContratoForm contratoform,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView(CONTRATO_UPDATE_FORM);
		modelAndView.addObject("contratoForm", contratoform);

		if (!bindingResult.hasErrors()) {
			Contrato contrato = contratoform.toModel();
			contratoRepository.save(contrato);
			redirectAttributes.addFlashAttribute("message",
					new FlashMessage(FlashMessageType.success, "Contrato atualizado com suscesso."));
			modelAndView = new ModelAndView("redirect:/contratos/" + contrato.getId());
		}

		return modelAndView;
	}

}
