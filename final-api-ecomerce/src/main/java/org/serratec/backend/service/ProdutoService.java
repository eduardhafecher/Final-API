package org.serratec.backend.service;

import org.serratec.backend.dto.ProdutoRequestDTO;
import org.serratec.backend.dto.ProdutoResponseDTO;
import org.serratec.backend.entity.Produto;
import org.serratec.backend.exception.ProdutoException;
import org.serratec.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private CategoriaService categoriaService;

  // falta imaplementar o metodo listar...

    public ProdutoResponseDTO buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoException("O produto com ID " + id + " não foi encontrado."));
        return new ProdutoResponseDTO(produto);
    }


    public void remover(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoException("O produto" + id + " não foi encontrado para remoção."));
        produtoRepository.delete(produto);
    }

    // ... e implementar o inserir pq não tô conseguindo resolver a vinculação produto/categoria
    public ProdutoResponseDTO inserir(ProdutoRequestDTO produtoRequestDTO) {

    }
}
