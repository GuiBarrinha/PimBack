package com.example.ApiTarefa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiTarefa.entities.Tarefa;
import com.example.ApiTarefa.exception.ResourceNotFoundException;
import com.example.ApiTarefa.repository.TarefaRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
	public class TarefaService {

		@Autowired // Cria uma instancia da classe
		private TarefaRepository repository;

		// Criar uma nova tarefa
		public Tarefa insert(Tarefa tarefa) {
			return repository.save(tarefa);
		}
		
		// Retorna uma lista de tarefas
		public List<Tarefa> findAll() {
			return repository.findAll();
		}

		// Alterar uma tarefa
		public Tarefa update(Long id, Tarefa tarefa) {	
			try {
				Tarefa entity = repository.getReferenceById(id);
				updateData(entity, tarefa);
				return repository.save(entity);
			} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException();
			}
		}
		
		private void updateData(Tarefa entity, Tarefa obj) {
			entity.setTitulo(obj.getTitulo());
			entity.setDescricao(obj.getDescricao());
			entity.setStatus(obj.getStatus());
		}

		public void delete(Long id) {
			if (!repository.existsById(id)) {
				throw new ResourceNotFoundException();
			}
			repository.deleteById(id);
		}



}
