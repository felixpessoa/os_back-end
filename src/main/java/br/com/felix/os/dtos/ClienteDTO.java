package br.com.felix.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.felix.os.domain.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;
	
	@NotEmpty(message = "O campo Email é requerido")
	private String email;
	
	private String senha;

	@CPF
	@NotEmpty(message = "O campo CPF é requerido")
	private String cpf;

	@NotEmpty(message = "O campo TELEFONE é requerido")
	private String telefone;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dc;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.dc = obj.getDc();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getDc() {
		return dc;
	}

	public void setDc(LocalDateTime dc) {
		this.dc = dc;
	}



}
