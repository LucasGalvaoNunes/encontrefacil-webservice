package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.FavoritosPessoaFisicaDAO;
import br.com.OpetBrothers.dto.FavoritosPessoaFisicaEntityDTO;
import br.com.OpetBrothers.repository.FavoritosPessoaFisicaRepository;
import br.com.OpetBrothers.repository.entity.FavoritosPessoaFisicaEntity;

@Path("/FavoritosPessoaFisica")
public class FavoritosPessoaFisicaController implements FavoritosPessoaFisicaDAO{
	private FavoritosPessoaFisicaRepository repository = new FavoritosPessoaFisicaRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public FavoritosPessoaFisicaEntityDTO Cadastrar(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity) {
		return this.repository.Cadastrar(pFavoritosPessoaFisicaEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public FavoritosPessoaFisicaEntityDTO Atualizar(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity) {
		return this.repository.Atualizar(pFavoritosPessoaFisicaEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public FavoritosPessoaFisicaEntityDTO Excluir(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity) {
		return this.repository.Excluir(pFavoritosPessoaFisicaEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public FavoritosPessoaFisicaEntityDTO GetFavoritosPessoaFisica(@PathParam("pId")int pId) {
		return this.repository.GetFavoritosPessoaFisica(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public FavoritosPessoaFisicaEntityDTO TodasFavoritos() {
		return this.repository.TodasFavoritos();
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/TodasPorPessoa/{pId}")
	public FavoritosPessoaFisicaEntityDTO GetTodasPorPessoa(@PathParam("pId")int pId) {
		return this.repository.GetTodasPorPessoa(pId);
	}
	
	
}
