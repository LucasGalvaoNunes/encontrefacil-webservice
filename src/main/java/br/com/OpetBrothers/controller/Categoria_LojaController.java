package br.com.OpetBrothers.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.Categoria_LojaEntityDTO;
import br.com.OpetBrothers.repository.Categoria_LojaRepository;

@Path("CategoriaLoja")
public class Categoria_LojaController
{
	private Categoria_LojaRepository repository = new Categoria_LojaRepository();
	
	@GET
	@Produces("application/json")
	@Path("/Todas")
	public Categoria_LojaEntityDTO TodasCategorias(){
		return this.repository.TodasCategorias();
	}
}
