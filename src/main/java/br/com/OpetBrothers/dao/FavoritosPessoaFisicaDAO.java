package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.FavoritosPessoaFisicaEntityDTO;
import br.com.OpetBrothers.repository.entity.FavoritosPessoaFisicaEntity;

public interface FavoritosPessoaFisicaDAO {
	FavoritosPessoaFisicaEntityDTO Cadastrar(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity);
	
	FavoritosPessoaFisicaEntityDTO Atualizar(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity);
	
	FavoritosPessoaFisicaEntityDTO Excluir(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity);
	
	FavoritosPessoaFisicaEntityDTO GetFavoritosPessoaFisica(int pId);
	
	FavoritosPessoaFisicaEntityDTO TodasFavoritos();
}
