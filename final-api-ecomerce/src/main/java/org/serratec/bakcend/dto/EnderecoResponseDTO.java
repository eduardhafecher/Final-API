package org.serratec.bakcend.dto;

import org.serratec.bakcend.entity.Endereco;

public record EnderecoResponseDTO (String cep, String logradouro, String bairro, String localidade, String uf){

	//construtor
		public EnderecoResponseDTO(Endereco endereco) {
			this(endereco.getCep(),
					endereco.getLogradouro(),
					endereco.getBairro(), 
					endereco.getLocalidade(), 
					endereco.getUf()
					);
		}
}
