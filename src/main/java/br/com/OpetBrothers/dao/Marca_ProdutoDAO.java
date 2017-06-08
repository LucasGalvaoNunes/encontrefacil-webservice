package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.Marca_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Marca_ProdutoEntity;

public interface Marca_ProdutoDAO {

	Marca_ProdutoEntityDTO Cadastrar(Marca_ProdutoEntity pMarca_ProdutoEntity);
	
	Marca_ProdutoEntityDTO Atualizar(Marca_ProdutoEntity pMarca_ProdutoEntity);
	
	Marca_ProdutoEntityDTO Excluir(Marca_ProdutoEntity pMarca_ProdutoEntity);
	
	Marca_ProdutoEntityDTO GetMarca_Produto(int pId);
	
	Marca_ProdutoEntityDTO TodasMarca_Produto();
}
