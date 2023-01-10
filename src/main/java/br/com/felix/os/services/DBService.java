package br.com.felix.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felix.os.domain.Cliente;
import br.com.felix.os.domain.OS;
import br.com.felix.os.domain.Tecnico;
import br.com.felix.os.domain.enuns.Perfil;
import br.com.felix.os.domain.enuns.Prioridade;
import br.com.felix.os.domain.enuns.Status;
import br.com.felix.os.repository.ClienteRepository;
import br.com.felix.os.repository.OSRepository;
import br.com.felix.os.repository.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instaciaDB() {
		Tecnico tec1 = new Tecnico(null, "Felix pessoa", "felixpessoa90@gmail.com", "12345678", "56920064057", "(81) 98363-3984");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "Linus@gmail.com", "12345678", "64636695046", "(22) 2933-7426");
				
		OS os1 = new OS(null, Prioridade.MEDIA, "Chamado 01", Status.ANDAMENTO, tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		osRepository.saveAll(Arrays.asList(os1));
		
	}
	
}
