package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.Marca_ProdutoDAO;
import br.com.OpetBrothers.dto.Marca_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.Marca_ProdutoRepository;
import br.com.OpetBrothers.repository.entity.Marca_ProdutoEntity;

@Path("/MarcaProduto")
public class Marca_ProdutoController implements Marca_ProdutoDAO{
	private Marca_ProdutoRepository repository = new Marca_ProdutoRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public Marca_ProdutoEntityDTO Cadastrar(Marca_ProdutoEntity pMarca_ProdutoEntity) {
		return this.repository.Cadastrar(pMarca_ProdutoEntity);
	}

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public Marca_ProdutoEntityDTO Atualizar(Marca_ProdutoEntity pMarca_ProdutoEntity) {
		return this.repository.Atualizar(pMarca_ProdutoEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public Marca_ProdutoEntityDTO Excluir(Marca_ProdutoEntity pMarca_ProdutoEntity) {
		return this.repository.Excluir(pMarca_ProdutoEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public Marca_ProdutoEntityDTO GetMarca_Produto(@PathParam("pId")int pId) {
		return this.repository.GetMarca_Produto(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public Marca_ProdutoEntityDTO TodasMarca_Produto() {
		return this.repository.TodasMarca_Produto();
	}
	
	
}
