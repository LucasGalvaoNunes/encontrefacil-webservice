package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.Avaliacao_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Avaliacao_ProdutoEntity;

public interface Avaliacao_ProdutoDAO {
	Avaliacao_ProdutoEntityDTO Cadastrar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity);
	
	Avaliacao_ProdutoEntityDTO Atualizar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity);
	
	Avaliacao_ProdutoEntityDTO Excluir(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity);
	
	Avaliacao_ProdutoEntityDTO GetAvaliacao_Produto(int pId);
	
	Avaliacao_ProdutoEntityDTO TodasAvaliacao_Produto();
	
	Avaliacao_ProdutoEntityDTO TodasAvaliacoesProduto(int pIdProd);
}
