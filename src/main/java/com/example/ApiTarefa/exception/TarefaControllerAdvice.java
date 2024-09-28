package com.example.ApiTarefa.exception;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class TarefaControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> notFound(ResourceNotFoundException resourceNotFoundException) {
		MessageExceptionHandler messageExceptionHandler = 
				new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Recurso não encontrado");
						
		return new ResponseEntity<>(messageExceptionHandler, HttpStatus.NOT_FOUND );
	}
	
	@ResponseBody
	@ExceptionHandler(StatusInvalidException.class)
	public ResponseEntity<MessageExceptionHandler> statusInvalido(StatusInvalidException statusInvalidException) {
		MessageExceptionHandler messageExceptionHandler = 
				new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(), "status validos: não iniciado, em andamento, concluído");
						
		return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST );
	}

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageExceptionHandler> argumentNotValid(MethodArgumentNotValidException notValid) {
		
		BindingResult bindingResult = notValid.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		StringBuilder stringBuilder = new StringBuilder("erros");
		for (FieldError fieldError : fieldErrors) {
			stringBuilder.append(" | ");
			stringBuilder.append(" -> ");
			stringBuilder.append(fieldError.getField());
			stringBuilder.append(" = ");
			stringBuilder.append(fieldError.getDefaultMessage());
			stringBuilder.append(" <- ");
		}
						
		MessageExceptionHandler messageExceptionHandler = 
				new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(),stringBuilder.toString());
						
		return new ResponseEntity<>(messageExceptionHandler, HttpStatus.BAD_REQUEST );
	}
	

}
