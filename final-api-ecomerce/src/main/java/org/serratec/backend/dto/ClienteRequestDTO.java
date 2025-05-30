package org.serratec.backend.dto;

import org.hibernate.validator.constraints.br.CPF;
import org.serratec.backend.entity.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ClienteRequestDTO {

	@NotBlank
	private String nome;

	@Email
	private String email;
	
	@CPF
	private String cpf;

	@NotBlank
	private String senha;
	
	@NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\\d{8}", message = "CEP inválido. Deve conter exatamente 8 dígitos numéricos sem traço!!!!!!")
    private String cep;

//	Inserir o perfil em clientes
//	private Set<ClientePerfil> clientePerfis = new HashSet<>();

	
//	construtor cheio, o vazio esta como lombock
	public ClienteRequestDTO(Cliente cliente) {
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpf = cliente.getCpf();
		this.senha = cliente.getSenha();
	}
	
//	construtor para requisitar a informacao do cep
	public ClienteRequestDTO(String nome, String email, String cpf, String senha, /*Set<ClientePerfil> clientePerfis,*/ String cep) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
//        this.clientePerfis = clientePerfis;
        this.cep = cep;
    }
	
}

