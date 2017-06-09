package br.com.OpetBrothers.dao;


import br.com.OpetBrothers.dto.ProdutoDestaqueEntityDTO;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;
import br.com.OpetBrothers.repository.entity.ProdutoDestaqueEntity;

public interface ProdutoDestaqueDAO {
	
	ProdutoDestaqueEntityDTO PorLocalidade(LocalizacaoEntity pLocalizacao);
	
	ProdutoDestaqueEntityDTO Cadastrar(ProdutoDestaqueEntity pProdutoDestaqueEntity);
	
	ProdutoDestaqueEntityDTO ExcluirProdutosExpirados();
		
}
