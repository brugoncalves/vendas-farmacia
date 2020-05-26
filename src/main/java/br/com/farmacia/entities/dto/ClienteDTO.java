package br.com.farmacia.entities.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.farmacia.entities.Cliente;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="O preenchimento do nome do cliente é obrigatório")
	@Length(message = "Email inválido")
	private String nome;
	
	@NotEmpty(message = "O preenchimento do endereço de e-mail do cliente é obrigatório")
	@Email
	private String email;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Cliente obj) {
		super();
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}