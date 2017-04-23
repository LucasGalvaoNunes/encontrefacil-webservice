package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.LojaEntityDTO;
import br.com.OpetBrothers.repository.LojaRepository;
import br.com.OpetBrothers.repository.entity.LojaEntity;

@Path("/Loja")
public class LojaController 
{
	private LojaRepository repostitory = new LojaRepository();
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/Cadastrar")
	public LojaEntityDTO Salvar(LojaEntity pLojaEntity){
		return this.repostitory.Salvar(pLojaEntity);
	}
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/Alterar")
	public LojaEntityDTO Alterar(LojaEntity pLojaEntity){
		return this.repostitory.Alterar(pLojaEntity);
	}
	
	@DELETE
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/Excluir")
	public LojaEntityDTO Excluir(LojaEntity pLojaEntity){
		return this.repostitory.Excluir(pLojaEntity);
	}
	
	@GET
	@Produces("application/json")
	@Path("/LojasUsuario/{pIdUsuario}")
	public LojaEntityDTO LojasPorUsuario(@PathParam("pIdUsuario") int pIdUsuario){
		return  this.repostitory.LojasPorUsuario(pIdUsuario);
	}
			
}
