package com.cursos.apirestcurso.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //pois é uma entidade do banco de dados
@Table(name="TB_CURSO") //Nome da tabela no banco de dados
public class Curso implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id //id da tabela do banco de dados
	@GeneratedValue(strategy = GenerationType.AUTO)//cria automaticamente o id
	private long id;
	private String nome;
	private String descricao;
	private int tempo;
	int mensalidade;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public int getMensalidade() {
		return mensalidade;
	}
	public void setMensalidade(int mensalidade) {
		this.mensalidade = mensalidade;
	}
		
	
}
