package br.com.felix.os.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.felix.os.domain.enuns.Perfil;
@Entity

public class Cliente extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "cliente")
	private List<OS> list = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String email, String senha, String cpf, String telefone) {
		super(id, nome, email, senha, cpf, telefone);
		addPerfil(Perfil.CLIENTE);
	}

	public List<OS> getList() {
		return list;
	}

	public void setList(List<OS> list) {
		this.list = list;
	}
	

}
