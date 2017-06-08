package br.com.OpetBrothers.dao;


import br.com.OpetBrothers.dto.ProdutoDestaqueEntityDTO;
import br.com.OpetBrothers.repository.entity.ProdutoDestaqueEntity;

public interface ProdutoDestaqueDAO {
	
	ProdutoDestaqueEntityDTO PorLocalidade(String pBairro, String pCidade, String pEstado);
	
	ProdutoDestaqueEntityDTO Cadastrar(ProdutoDestaqueEntity pProdutoDestaqueEntity);
	
	ProdutoDestaqueEntityDTO ExcluirProdutosExpirados();
		
}
