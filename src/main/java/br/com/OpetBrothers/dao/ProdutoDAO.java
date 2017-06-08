package br.com.OpetBrothers.dao;


import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;

public interface ProdutoDAO {
	ProdutoEntityDTO Cadastrar(ProdutoEntity pProdutoEntity);
	
	ProdutoEntityDTO Atualizar(ProdutoEntity pProdutoEntity);
	
	ProdutoEntityDTO Excluir(ProdutoEntity pProdutoEntity);
	
	ProdutoEntityDTO GetProduto(int pId);
	
	ProdutoEntityDTO GetProdutodaLoja(int pId);
	
	ProdutoEntityDTO BuscarPorNome(String pBairro, String pCidade, String pEstado, String pNome);
	
	ProdutoEntityDTO BuscarPorCategoria(String pBairro, String pCidade, String pEstado, int pId);
	
	ProdutoEntityDTO RelatorioLoja(int pId);
	
	ProdutoEntityDTO ExcluirProdutosExpirados();
}
