package br.com.farmacia.api.dto;

import java.io.Serializable;

import br.com.farmacia.entities.Usuario;

public class VendedorDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	
	public VendedorDTO() {
		
	}
	
	public VendedorDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

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
	
	
}
