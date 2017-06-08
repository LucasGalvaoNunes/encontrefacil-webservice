package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.NotificacoesDAO;
import br.com.OpetBrothers.dto.NotificacoesEntityDTO;
import br.com.OpetBrothers.repository.NotificacoesRepository;
import br.com.OpetBrothers.repository.entity.NotificacoesEntity;

@Path("Notificacoes")
public class NotificacoesController implements NotificacoesDAO{
	private NotificacoesRepository repository = new NotificacoesRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public NotificacoesEntityDTO Cadastrar(NotificacoesEntity pNotificacoesEntity) {
		return this.repository.Cadastrar(pNotificacoesEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public NotificacoesEntityDTO Atualizar(NotificacoesEntity pNotificacoesEntity) {
		return this.repository.Atualizar(pNotificacoesEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public NotificacoesEntityDTO Excluir(NotificacoesEntity pNotificacoesEntity) {
		return this.repository.Excluir(pNotificacoesEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public NotificacoesEntityDTO GetNotificacoes(@PathParam("pId") int pId) {
		return this.repository.GetNotificacoes(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public NotificacoesEntityDTO TodasNotificacoes() {
		return this.repository.TodasNotificacoes();
	}
	
	
}
