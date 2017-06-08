package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.ProdutoDAO;
import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.repository.ProdutoRepository;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;

@Path("/Produto")
public class ProdutoController implements ProdutoDAO{
	private ProdutoRepository repository = new ProdutoRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public ProdutoEntityDTO Cadastrar(ProdutoEntity pProdutoEntity) {
		return this.repository.Cadastrar(pProdutoEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public ProdutoEntityDTO Atualizar(ProdutoEntity pProdutoEntity) {
		return this.repository.Atualizar(pProdutoEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public ProdutoEntityDTO Excluir(ProdutoEntity pProdutoEntity) {
		return this.repository.Excluir(pProdutoEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public ProdutoEntityDTO GetProduto(@PathParam("pId") int pId) {
		return this.repository.GetProduto(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/BuscarPorNome/{pBairro}/{pCidade}/{pEstado}/{pNome}")
	public ProdutoEntityDTO BuscarPorNome(@PathParam("pBairro")String pBairro, @PathParam("pCidade")String pCidade, @PathParam("pEstado")String pEstado, @PathParam("pNome")String pNome) {
		return this.repository.BuscarPorNome(pBairro, pCidade, pEstado, pNome);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/BuscarPorCategoria/{pBairro}/{pCidade}/{pEstado}/{pId}")
	public ProdutoEntityDTO BuscarPorCategoria(@PathParam("pBairro")String pBairro, @PathParam("pCidade")String pCidade, @PathParam("pEstado")String pEstado, @PathParam("pId") int pId) {
		return this.repository.BuscarPorCategoria(pBairro, pCidade, pEstado, pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/PorLoja/{pId}")
	public ProdutoEntityDTO RelatorioLoja(@PathParam("pId") int pId) {
		return this.repository.RelatorioLoja(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/GetPorLoja/{pId}")
	public ProdutoEntityDTO GetProdutodaLoja(@PathParam("pId")int pId) {
		return this.repository.GetProdutodaLoja(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/AtualizarProdutos")
	public ProdutoEntityDTO ExcluirProdutosExpirados() {
		return this.repository.ExcluirProdutosExpirados();
	}
	
}
