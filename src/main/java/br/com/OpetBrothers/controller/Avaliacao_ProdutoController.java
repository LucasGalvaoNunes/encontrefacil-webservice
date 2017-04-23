package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.Avaliacao_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.Avaliacao_ProdutoRepository;
import br.com.OpetBrothers.repository.entity.Avaliacao_ProdutoEntity;
@Path("/AvaliacaoProduto")
public class Avaliacao_ProdutoController
{
	private Avaliacao_ProdutoRepository repository = new Avaliacao_ProdutoRepository();
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Cadastrar")
	public Avaliacao_ProdutoEntityDTO Salvar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity){
		return this.repository.Salvar(pAvaliacao_ProdutoEntity);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Alterar")
	public Avaliacao_ProdutoEntityDTO Alterar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity){
		return this.repository.Alterar(pAvaliacao_ProdutoEntity);
	}
	
	@GET
	@Produces("application/json")
	@Path("/PorProduto/{pId}")
	public Avaliacao_ProdutoEntityDTO PorProduto(@PathParam("pId") int pIdProduto){
		return this.repository.PorProduto(pIdProduto);
	}
}
