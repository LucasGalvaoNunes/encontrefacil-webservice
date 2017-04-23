package br.com.OpetBrothers.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.Categoria_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.Categoria_ProdutoRepository;

@Path("/CategoriaProduto")
public class Categoria_ProdutoController {
	
	private Categoria_ProdutoRepository repository = new Categoria_ProdutoRepository();
	
	@GET
	@Produces("application/json")
	@Path("/Todas")
	public Categoria_ProdutoEntityDTO TodasCategorias(){
		return this.repository.TodasCategorias();
	}

}
