package br.com.cursospringboot.PrimeiroProjeto.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Usuario implements Serializable {

	/*
	 * O que é o serialVersionUID? Esse é um atributo utilizado para controlar
	 * explicitamente a compatibilidade entre o .class usado para serializar e o
	 * .class que será utilizado na desserialização.
	 */
	private static final long serialVersionUID = 1L;

	// Attr
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@Size(max = 100) 
	private String nome;
	private int idade;
	
	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
