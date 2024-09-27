package com.example.ApiTarefa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiTarefa.entities.Tarefa;
import com.example.ApiTarefa.repository.TarefaRepository;

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


}
