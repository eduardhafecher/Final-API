package org.serratec.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.config.MailConfig;
import org.serratec.backend.dto.ClienteRequestDTO;
import org.serratec.backend.dto.ClienteResponseDTO;
import org.serratec.backend.entity.Cliente;
import org.serratec.backend.entity.Endereco;
import org.serratec.backend.exception.ClienteException;
import org.serratec.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repoCliente;
	
//	@Autowired
//	private PerfilService perfilService;
//	
//	@Autowired
//	private ClientePerfilRepository clientePerfilRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private MailConfig mailConfig;
	
	@Autowired
	private EnderecoService endServ;
	
	public List<ClienteResponseDTO> listar(){
		List<Cliente> clientes = repoCliente.findAll();
		List<ClienteResponseDTO> clientesDTO = new ArrayList<>();
		for(Cliente cliente : clientes) {
			clientesDTO.add(new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail()));
		}
		return clientesDTO;
	}
	
	@Transactional
	public ClienteResponseDTO inserir(ClienteRequestDTO cliente) {
		Optional<Cliente> u = repoCliente.findByEmail(cliente.getEmail());
		
		endServ.buscar(cliente.getCep());									//Verifica/cria o endereco na tabela
		Endereco end = endServ.buscarEndereco(cliente.getCep());			//Chama o metodo em endereco service
		
		if(u.isPresent()) {
			throw new ClienteException("Email já cadastrado");
		}
		
		Cliente clienteEntity = new Cliente();
		clienteEntity.setNome(cliente.getNome());
		clienteEntity.setEmail(cliente.getEmail());
		clienteEntity.setCpf(cliente.getCpf());
		
//		cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
//		
//		clienteEntity.setSenha(cliente.getSenha());
		
		clienteEntity.setSenha(passwordEncoder.encode(cliente.getSenha()));
		
		clienteEntity.setEndereco(end);									//Inclui endereco no objeto
		
//		for (ClientePerfil up: cliente.getClientePerfis()) {
//			up.setPerfil(perfilService.buscar(up.getPerfil().getId()));
//			up.setCliente(clienteEntity);
//			up.setDataCriacao(LocalDate.now());
//		}
		
		clienteEntity=repoCliente.save(clienteEntity);
		
//		clientePerfilRepository.saveAll(cliente.getClientePerfis());
		
//		mailConfig.enviar(clienteEntity.getEmail(), "Confirmação de Cadastro", cliente.toString());
	
		return new ClienteResponseDTO(clienteEntity.getId(), clienteEntity.getNome(), clienteEntity.getEmail());
	
	}
}	