package com.example.ApiTarefa.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	// Endpoint de listar tarefa
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll() {
		List<Tarefa> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	// Endpoint de alterar tarefa
	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> update(@PathVariable long id, @Valid @RequestBody Tarefa tarefa) {
		tarefa = service.update(id, tarefa);
		return ResponseEntity.ok().body(tarefa);
	}

	// Endpoint de deletar tarefa
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// Endpoint de busca por id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable long id) {
		Tarefa tarefa = service.findById(id);
		return ResponseEntity.ok().body(tarefa);
	}

}
