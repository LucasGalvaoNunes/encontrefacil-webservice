package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.NotificacoesEntityDTO;
import br.com.OpetBrothers.repository.entity.NotificacoesEntity;

public interface NotificacoesDAO {

	NotificacoesEntityDTO Cadastrar(NotificacoesEntity pNotificacoesEntity);
	
	NotificacoesEntityDTO Atualizar(NotificacoesEntity pNotificacoesEntity);
	
	NotificacoesEntityDTO Excluir(NotificacoesEntity pNotificacoesEntity);
	
	NotificacoesEntityDTO GetNotificacoes(int pId);
	
	NotificacoesEntityDTO TodasNotificacoes();
}
