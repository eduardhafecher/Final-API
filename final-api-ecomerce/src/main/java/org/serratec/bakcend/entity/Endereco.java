package org.serratec.bakcend.entity;

import org.serratec.bakcend.dto.EnderecoResponseDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Long id;
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;

	//criado para retornar metodo em service buscarEndereco
	public Endereco(EnderecoResponseDTO dto) {
		this.cep = dto.cep();
		this.logradouro = dto.logradouro();
		this.bairro = dto.bairro();
		this.localidade = dto.bairro();
		this.uf = dto.bairro();
	}
}
