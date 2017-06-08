package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.LocalizacaoDAO;
import br.com.OpetBrothers.dto.LocalizacaoEntityDTO;
import br.com.OpetBrothers.repository.LocalizacaoRepository;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;

@Path("/Localizacao")
public class LocalizacaoController implements LocalizacaoDAO{

	private LocalizacaoRepository repository = new LocalizacaoRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public LocalizacaoEntityDTO Cadastrar(LocalizacaoEntity pLocalizacaoEntity) {
		return repository.Cadastrar(pLocalizacaoEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public LocalizacaoEntityDTO Atualizar(LocalizacaoEntity pLocalizacaoEntity) {
		return repository.Atualizar(pLocalizacaoEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public LocalizacaoEntityDTO Excluir(LocalizacaoEntity pLocalizacaoEntity) {
		return repository.Excluir(pLocalizacaoEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public LocalizacaoEntityDTO GetLocalizacao(@PathParam("pId") int pId) {
		return repository.GetLocalizacao(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todos")
	public LocalizacaoEntityDTO TodasLocalizacao() {
		return repository.TodasLocalizacao();
	}
	
	
}
