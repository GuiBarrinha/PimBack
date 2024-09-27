package com.example.ApiTarefa.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Size(min = 2, max = 100)
	@NotNull
	private String titulo;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	@NotNull
	private String descricao;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	@NotNull
	private String status;

	
	public Tarefa() {
	}

	public Tarefa(Long id, String titulo, String descricao, String status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
