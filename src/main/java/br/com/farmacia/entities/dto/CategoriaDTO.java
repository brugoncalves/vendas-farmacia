package br.com.farmacia.entities.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.farmacia.entities.Categoria;

public class CategoriaDTO {

	private Long id;
	@NotEmpty(message="O preenchimento do nome da categoria é obrigatório")
	@Length(min=5, max=80, message="O nome da categoria deve conter entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Categoria obj) {
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
