package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.repository.ProdutoRepository;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;
@Path("/Produto")
public class ProdutoController 
{
	private ProdutoRepository  repository  = new ProdutoRepository();
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Cadastrar")
	public ProdutoEntityDTO Salvar(ProdutoEntity pProdutoEntity){
		return this.repository.Salvar(pProdutoEntity);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Alterar")
	public ProdutoEntityDTO Alterar(ProdutoEntity pProdutoEntity){
		return this.repository.Alterar(pProdutoEntity);
	}
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Excluir")
	public ProdutoEntityDTO Excluir(ProdutoEntity pProdutoEntity){
		return this.repository.Excluir(pProdutoEntity);
	}
	
	@GET
	@Produces("application/json")
	@Path("/PorCategoria/{pCategoria}")
	public ProdutoEntityDTO PorCategoria(@PathParam("pCategoria") String pCategoria){
		return this.repository.PorCategoria(pCategoria);
	}
	
	@GET
	@Produces("application/json")
	@Path("/PorMarca/{pMarca}")
	public ProdutoEntityDTO PorMarca(@PathParam("pMarca") String pMarca){
		return this.repository.PorMarca(pMarca);
	}
	
	@GET
	@Produces("application/json")
	@Path("/PorLoja/{pIdLoja}")
	public ProdutoEntityDTO PorLoja(@PathParam("pIdLoja") int pIdLoja){
		return this.repository.PorLoja(pIdLoja);
	}
	
	@GET
	@Produces("application/json")
	@Path("/Tudo")
	public ProdutoEntityDTO Tudo(){
		return this.repository.Tudo();
	}
}
