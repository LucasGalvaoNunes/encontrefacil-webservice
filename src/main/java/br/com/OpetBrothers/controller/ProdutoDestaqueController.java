package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.ProdutoDestaqueDAO;
import br.com.OpetBrothers.dto.ProdutoDestaqueEntityDTO;
import br.com.OpetBrothers.repository.ProdutoDestaqueRepository;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;
import br.com.OpetBrothers.repository.entity.ProdutoDestaqueEntity;

@Path("/ProdutoDestaque")
public class ProdutoDestaqueController implements ProdutoDestaqueDAO{

	private ProdutoDestaqueRepository repository = new ProdutoDestaqueRepository();
	
	@Override
	@POST
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/Buscar")
	public ProdutoDestaqueEntityDTO PorLocalidade(LocalizacaoEntity pLocalizacao) {
		return this.repository.PorLocalidade(pLocalizacao);
	}

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public ProdutoDestaqueEntityDTO Cadastrar(ProdutoDestaqueEntity pProdutoDestaqueEntity) {
		return this.repository.Cadastrar(pProdutoDestaqueEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/AtualizarProdutos")
	public ProdutoDestaqueEntityDTO ExcluirProdutosExpirados() {
		return this.repository.ExcluirProdutosExpirados();
	}

}
