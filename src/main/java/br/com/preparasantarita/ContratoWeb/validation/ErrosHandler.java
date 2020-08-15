package br.com.preparasantarita.ContratoWeb.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrosHandler {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDto> handle(MethodArgumentNotValidException e) {
		List<ErroFormularioDto> listaErro = new ArrayList<ErroFormularioDto>();

		List<FieldError> fieldError = e.getBindingResult().getFieldErrors();

		fieldError.forEach(f -> {
			String mensagem = messageSource.getMessage(f, LocaleContextHolder.getLocale());
			ErroFormularioDto erroFormularioDto = new ErroFormularioDto(f.getField(), mensagem);
			listaErro.add(erroFormularioDto);
		});

		return listaErro;
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ModelAndView handleNodataFoundException(RecursoNaoEncontradoException ex, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("errors/404");

		modelAndView.setStatus(HttpStatus.NOT_FOUND);

		return modelAndView;
	}

}
