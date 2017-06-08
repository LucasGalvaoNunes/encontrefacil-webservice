package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.Categoria_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_ProdutoEntity;

public interface Categoria_ProdutoDAO {
	Categoria_ProdutoEntityDTO Cadastrar(Categoria_ProdutoEntity pCategoria_ProdutoEntity);
	
	Categoria_ProdutoEntityDTO Atualizar(Categoria_ProdutoEntity pCategoria_ProdutoEntity);
	
	Categoria_ProdutoEntityDTO Excluir(Categoria_ProdutoEntity pCategoria_ProdutoEntity);
	
	Categoria_ProdutoEntityDTO GetCategoria_Produto(int pId);
	
	Categoria_ProdutoEntityDTO TodasCategorias_Produto();
}
