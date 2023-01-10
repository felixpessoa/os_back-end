package br.com.felix.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.felix.os.domain.Tecnico;
import br.com.felix.os.domain.enuns.Perfil;

public class TecnicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Ocampo NOME é requerido")
	private String nome;
	@NotEmpty(message = "Ocampo Email é requerido")
	private String email;
	private String senha;
	@CPF
	@NotEmpty(message = "O campo CPF é requerido")
	private String cpf;
	@NotEmpty(message = "O campo TELEFONE é requerido")
	private String telefone;
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dc;

	public TecnicoDTO() {
		super();
	}

	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
		this.perfis = obj.getPerfils().stream().map(x -> x.getCod()).collect(Collectors.toSet());
		this.dc = obj.getDc();
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
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public LocalDateTime getDc() {
		return dc;
	}

	public void setDc(LocalDateTime dc) {
		this.dc = dc;
	}

}
