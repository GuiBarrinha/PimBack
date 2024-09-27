package com.example.ApiTarefa.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ApiTarefa.entities.Tarefa;
import com.example.ApiTarefa.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/tarefas") // Endereço de acesso de API
public class TarefaController {

	@Autowired // Cria uma instancia da classe
	private TarefaService service;

	// Endpoint de incluir tarefa
	@PostMapping
	public ResponseEntity<Tarefa> insert(@Valid @RequestBody Tarefa tarefa) {
		tarefa = service.insert(tarefa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
		return ResponseEntity.created(uri).body(tarefa);
	}

}
