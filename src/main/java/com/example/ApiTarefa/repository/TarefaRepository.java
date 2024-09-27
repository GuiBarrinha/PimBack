package com.example.ApiTarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiTarefa.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
