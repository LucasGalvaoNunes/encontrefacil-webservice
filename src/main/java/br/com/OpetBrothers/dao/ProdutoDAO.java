package br.com.OpetBrothers.dao;


import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;

public interface ProdutoDAO {
	ProdutoEntityDTO Cadastrar(ProdutoEntity pProdutoEntity);
	
	ProdutoEntityDTO Atualizar(ProdutoEntity pProdutoEntity);
	
	ProdutoEntityDTO Excluir(ProdutoEntity pProdutoEntity);
	
	ProdutoEntityDTO GetProduto(int pId);
	
	ProdutoEntityDTO GetProdutodaLoja(int pId);
	
	ProdutoEntityDTO BuscarPorNome(LocalizacaoEntity pLocalizacao, String pNome);
	
	ProdutoEntityDTO BuscarPorCategoria(LocalizacaoEntity pLocalizacao, int pId);
	
	ProdutoEntityDTO RelatorioLoja(int pId);
	
	ProdutoEntityDTO ExcluirProdutosExpirados();
}
