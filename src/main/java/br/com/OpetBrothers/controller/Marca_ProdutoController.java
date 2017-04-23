package br.com.OpetBrothers.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.Marca_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.Marca_ProdutoRepository;

@Path("/MarcaProduto")
public class Marca_ProdutoController 
{
	private Marca_ProdutoRepository repository = new Marca_ProdutoRepository();
	
	@GET
	@Produces("application/json")
	@Path("/Todas")
	public Marca_ProdutoEntityDTO TodasMarcas()
	{
		return this.repository.TodasMarcas();
	}
	
}
