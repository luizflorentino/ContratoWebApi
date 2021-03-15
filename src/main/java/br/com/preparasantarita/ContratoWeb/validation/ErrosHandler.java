package br.com.preparasantarita.ContratoWeb.validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class ErrosHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MethodArgumentNotValidException> handle(MethodArgumentNotValidException ex) {
	return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<RecursoNaoEncontradoException> handleNodataFoundException(RecursoNaoEncontradoException ex,
	    WebRequest request) {
	return ResponseEntity.badRequest().body(ex);
    }
}
