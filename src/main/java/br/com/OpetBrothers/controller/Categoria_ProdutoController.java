package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.Categoria_ProdutoDAO;
import br.com.OpetBrothers.dto.Categoria_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.Categoria_ProdutoRepository;
import br.com.OpetBrothers.repository.entity.Categoria_ProdutoEntity;

@Path("/CategoriaProduto")
public class Categoria_ProdutoController implements Categoria_ProdutoDAO{
	private Categoria_ProdutoRepository repository = new Categoria_ProdutoRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public Categoria_ProdutoEntityDTO Cadastrar(Categoria_ProdutoEntity pCategoria_ProdutoEntity) {
		return this.repository.Cadastrar(pCategoria_ProdutoEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public Categoria_ProdutoEntityDTO Atualizar(Categoria_ProdutoEntity pCategoria_ProdutoEntity) {
		return this.repository.Atualizar(pCategoria_ProdutoEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public Categoria_ProdutoEntityDTO Excluir(Categoria_ProdutoEntity pCategoria_ProdutoEntity) {
		return this.repository.Excluir(pCategoria_ProdutoEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public Categoria_ProdutoEntityDTO GetCategoria_Produto(@PathParam("pId") int pId) {
		return this.repository.GetCategoria_Produto(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public Categoria_ProdutoEntityDTO TodasCategorias_Produto() {
		return this.repository.TodasCategorias_Produto();
	}
	
	
}
