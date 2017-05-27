package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.Categoria_LojaDAO;
import br.com.OpetBrothers.dto.Categoria_LojaEntityDTO;
import br.com.OpetBrothers.repository.Categoria_LojaRepository;
import br.com.OpetBrothers.repository.entity.Categoria_LojaEntity;

@Path("/CategoriaLoja")
public class Categoria_LojaController implements Categoria_LojaDAO {
	private Categoria_LojaRepository repository = new Categoria_LojaRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public Categoria_LojaEntityDTO Cadastrar(Categoria_LojaEntity pCategoria_LojaEntity) {
		return this.repository.Cadastrar(pCategoria_LojaEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public Categoria_LojaEntityDTO Atualizar(Categoria_LojaEntity pCategoria_LojaEntity) {
		return this.repository.Atualizar(pCategoria_LojaEntity);
	}

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public Categoria_LojaEntityDTO Excluir(Categoria_LojaEntity pCategoria_LojaEntity) {
		return this.repository.Excluir(pCategoria_LojaEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public Categoria_LojaEntityDTO GetCategoria_Loja(@PathParam("pId") int pId) {
		return this.repository.GetCategoria_Loja(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public Categoria_LojaEntityDTO TodasCategorias_Loja() {
		return this.repository.TodasCategorias_Loja();
	}
	
	
	
}
