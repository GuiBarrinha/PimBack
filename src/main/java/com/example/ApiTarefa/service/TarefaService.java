package com.example.ApiTarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiTarefa.entities.Tarefa;
import com.example.ApiTarefa.exception.ResourceNotFoundException;
import com.example.ApiTarefa.exception.StatusInvalidException;
import com.example.ApiTarefa.repository.TarefaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {

	@Autowired // Cria uma instancia da classe
	private TarefaRepository repository;

	// Criar uma nova tarefa
	public Tarefa insert(Tarefa tarefa) {
//		System.out.println("status = " + tarefa.getStatus());
//		if ((tarefa.getStatus().equalsIgnoreCase("não iniciado"))
//				|| (tarefa.getStatus().equalsIgnoreCase("em andamento"))
//				|| (tarefa.getStatus().equalsIgnoreCase("concluido"))) {
//			return repository.save(tarefa);
//		} else {
//			throw new StatusInvalidException();
//		}
		validaStatus(tarefa.getStatus());
		return repository.save(tarefa);
	}

	// Retorna uma lista de tarefas
	public List<Tarefa> findAll() {
		return repository.findAll();
	}

	// Alterar uma tarefa
	public Tarefa update(Long id, Tarefa tarefa) {
		validaStatus(tarefa.getStatus());
		try {
			Tarefa entity = repository.getReferenceById(id);
			updateData(entity, tarefa);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException();
		}
	}
	
//	private void validaStatus(String status) {
//		System.out.println("passou 1");
//		if ((status.equalsIgnoreCase("não iniciado"))
//				|| (status.equalsIgnoreCase("em andamento"))
//				|| (status.equalsIgnoreCase("concluido"))) {
//			System.out.println("passou 2");
//		} else {
//			System.out.println("passou 3");
//			throw new StatusInvalidException();
//		}
//	}

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

	// Retorna uma tarefa pelo id
	public Tarefa findById(long id) {
		Optional<Tarefa> tarefa = repository.findById(id);
		return tarefa.orElseThrow(() -> new ResourceNotFoundException());
	}

	private void validaStatus(String status) {
		if (!(status.equalsIgnoreCase("não iniciado"))
				&& !(status.equalsIgnoreCase("em andamento"))
				&& !(status.equalsIgnoreCase("concluido"))) {
			throw new StatusInvalidException();
		}
	}
}
