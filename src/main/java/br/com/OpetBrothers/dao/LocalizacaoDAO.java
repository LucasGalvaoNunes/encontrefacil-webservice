package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.LocalizacaoEntityDTO;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;

public interface LocalizacaoDAO {
	LocalizacaoEntityDTO Cadastrar(LocalizacaoEntity pLocalizacaoEntity);
	
	LocalizacaoEntityDTO Atualizar(LocalizacaoEntity pLocalizacaoEntity);
	
	LocalizacaoEntityDTO Excluir(LocalizacaoEntity pLocalizacaoEntity);
	
	LocalizacaoEntityDTO GetLocalizacao(int pId);
	
	LocalizacaoEntityDTO TodasLocalizacao();
}
