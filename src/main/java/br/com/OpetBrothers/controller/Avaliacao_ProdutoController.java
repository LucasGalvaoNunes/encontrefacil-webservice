package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.Avaliacao_ProdutoDAO;
import br.com.OpetBrothers.dto.Avaliacao_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.Avaliacao_ProdutoRepository;
import br.com.OpetBrothers.repository.entity.Avaliacao_ProdutoEntity;

@Path("/AvaliacaoProduto")
public class Avaliacao_ProdutoController implements Avaliacao_ProdutoDAO {

	private Avaliacao_ProdutoRepository repository = new Avaliacao_ProdutoRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public Avaliacao_ProdutoEntityDTO Cadastrar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity) {
		return this.repository.Cadastrar(pAvaliacao_ProdutoEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public Avaliacao_ProdutoEntityDTO Atualizar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity) {
		return this.repository.Atualizar(pAvaliacao_ProdutoEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public Avaliacao_ProdutoEntityDTO Excluir(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity) {
		return this.repository.Excluir(pAvaliacao_ProdutoEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public Avaliacao_ProdutoEntityDTO GetAvaliacao_Produto(@PathParam("pId") int pId) {
		return this.repository.GetAvaliacao_Produto(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public Avaliacao_ProdutoEntityDTO TodasAvaliacao_Produto() {
		return this.repository.TodasAvaliacao_Produto();
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/AvaliacaoProduto/{pIdProd}")
	public Avaliacao_ProdutoEntityDTO TodasAvaliacoesProduto(@PathParam("pIdProd") int pIdProd) {
		return this.repository.TodasAvaliacoesProduto(pIdProd);
	}
	
	
	
	
}
