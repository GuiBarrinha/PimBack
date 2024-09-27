package com.example.ApiTarefa.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


}
